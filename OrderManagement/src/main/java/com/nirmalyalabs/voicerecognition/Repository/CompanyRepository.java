package com.nirmalyalabs.voicerecognition.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmalyalabs.voicerecognition.Entity.Company;


@Repository
public interface CompanyRepository  extends JpaRepository<Company, String>{

	
	
}
