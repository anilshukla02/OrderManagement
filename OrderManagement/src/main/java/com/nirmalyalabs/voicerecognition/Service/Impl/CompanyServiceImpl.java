package com.nirmalyalabs.voicerecognition.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.Company;
import com.nirmalyalabs.voicerecognition.Repository.CompanyRepository;
import com.nirmalyalabs.voicerecognition.Service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	public Company GetCompany() {
		
		return companyRepository.findAll().get(0);
	}

}
