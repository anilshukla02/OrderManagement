package com.nirmalyalabs.voicerecognition.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmalyalabs.voicerecognition.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	public List<Customer> findByCustnameIgnoreCase(String custname);

}
