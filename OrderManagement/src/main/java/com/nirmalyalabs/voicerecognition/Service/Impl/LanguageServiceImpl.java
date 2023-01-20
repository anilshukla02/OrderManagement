package com.nirmalyalabs.voicerecognition.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.language;
import com.nirmalyalabs.voicerecognition.Repository.LanguagesRepository;
import com.nirmalyalabs.voicerecognition.Service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	LanguagesRepository languagesrepository;
	
	@Override
	public List<language> getAllLanguages() {
		return languagesrepository.findAll();
	}

	@Override
	public List<String> getAllSupportedLangCodes() {
		List<language> list = languagesrepository.findAll();
		List<String> langCodes = list.stream().map(language:: getLangcode)
				                  .collect(Collectors.toList());
		return langCodes;
	}

}
