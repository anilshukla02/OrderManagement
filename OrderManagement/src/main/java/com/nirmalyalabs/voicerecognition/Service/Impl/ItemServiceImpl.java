package com.nirmalyalabs.voicerecognition.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.ItemMaster;
import com.nirmalyalabs.voicerecognition.Repository.ItemMasterRepository;
import com.nirmalyalabs.voicerecognition.Service.ItemsService;

@Service
public class ItemServiceImpl implements ItemsService {

	@Autowired
	ItemMasterRepository itemMasterRepository;

	@Override
	public ItemMaster saveItem(ItemMaster item) {
		return itemMasterRepository.save(item);
	}

	@Override
	public List<ItemMaster> getAllItems() {
		return itemMasterRepository.findAll();
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

		if (!match1.isEmpty()) {
			itemId = match1.get(0).getItemId();
		} else if (!match2.isEmpty()) {
			itemId = match2.get(0).getItemId();
		}

		return itemId;
	}

}
