package com.nirmalyalabs.voicerecognition.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nirmalyalabs.voicerecognition.Entity.ItemMaster;
import com.nirmalyalabs.voicerecognition.Entity.MyuserDetails;
import com.nirmalyalabs.voicerecognition.Repository.ItemMasterRepository;
import com.nirmalyalabs.voicerecognition.Service.ItemsService;
import com.nirmalyalabs.voicerecognition.Service.LanguageService;
import com.nirmalyalabs.voicerecognition.Service.TranslationProvider;
import com.nirmalyalabs.voicerecognition.Utilities.General.GeneralUtilities;

@Service
public class ItemServiceImpl implements ItemsService {

	@Autowired
	ItemMasterRepository itemMasterRepository;

	@Autowired
	TranslationProvider translationProvider;

	@Autowired
	LanguageService languageService;

	@Autowired
	GeneralUtilities generalUtilities;

	@Override
	public ItemMaster saveItem(ItemMaster item) {

		ItemMaster itemTemp = itemMasterRepository.save(item);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyuserDetails userDetails = (MyuserDetails) authentication.getPrincipal();

		final String currLang = userDetails.getPreflang();

		new Thread(() -> {
			updateItemAlias(item, currLang);
		}).start();

		/*
		 * CompletableFuture.runAsync(() -> { // method call or code to be asynch.
		 * updateItemAlias(item); });
		 */
		return itemTemp;
	}

	public ItemMaster updateItemAlias(ItemMaster item, String currLang) {

		List<String> allSupportedLanguages = languageService.getAllSupportedLangCodes();
		Map<String, String> allTranslations = new HashMap<>();

		allSupportedLanguages.remove(currLang);

		for (String lang : allSupportedLanguages) {

			String translatedName = translationProvider.getTranslation(item.getItemname(), currLang, lang);
			allTranslations.put(lang, translatedName);
		}

		allTranslations.put(currLang, item.getItemname()); // users language alias
		// Actual Item name will always be in English for consistency purposes and
		// aliases are in all languages
		if (!currLang.equals("en-IN")) {
			item.setItemname(allTranslations.get("en-IN"));
			// allTranslations.remove("en-IN"); // let English translation also be in alias
		}

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			String json = objectMapper.writeValueAsString(allTranslations);
			item.setItemAlias(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return itemMasterRepository.save(item);

	}

	@Override
	public List<ItemMaster> getAllItems() {

		List<ItemMaster> tempList = itemMasterRepository.findAll();

		// update item names to preferred language before display

		for (ItemMaster item : tempList) {
			String aliases = item.getItemAlias();
			Map<String, String> map = new HashMap<String, String>();
			ObjectMapper mapper = new ObjectMapper();
			if (aliases != null) {
				try {
					map = mapper.readValue(aliases, map.getClass());
					item.setItemname(map.get(generalUtilities.getUserLanguage()));
				} catch (JsonMappingException e) {
					System.out.println("Exception while reading Item alias");
				} catch (JsonProcessingException e) {
					System.out.println("Exception while reading Item alias");
				}
			}
		}

		return tempList;

	}

	@Override
	public ItemMaster GetItemByID(Long id) {
		ItemMaster itemMaster = itemMasterRepository.findById(id).get();
		return itemMaster;
	}

	@Override
	public void DeleteItemByID(Long id) {
		itemMasterRepository.deleteById(id);
		return;
	}

	@Override
	public long GetItemByName(String itemName) {

		long itemId = -1;

		List<ItemMaster> match1 = itemMasterRepository.findByItemnameIgnoreCase(itemName);
		List<ItemMaster> match2 = itemMasterRepository.findByItemAliasIgnoreCaseContaining(itemName);

		if (!match1.isEmpty()) { // item name found in Itemname field
			itemId = match1.get(0).getItemId();
		} else if (!match2.isEmpty()) { // item name found in ItemAlias field
			itemId = match2.get(0).getItemId();
		}

		return itemId;
	}

}
