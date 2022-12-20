package com.nirmalyalabs.voicerecognition.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.Customer;
import com.nirmalyalabs.voicerecognition.Repository.CustomerRepository;
import com.nirmalyalabs.voicerecognition.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer GetCustomerByID(Long id) {
		Customer customer = customerRepository.findById(id).get();
		return customer;
	}

	@Override
	public List<Customer> GetCustomerByName(String custname) {
		return customerRepository.findByCustnameIgnoreCase(custname);
	}

	@Override
	public void DeleteCustomerByID(Long id) {
		customerRepository.deleteById(id);
        return;
	}

}
