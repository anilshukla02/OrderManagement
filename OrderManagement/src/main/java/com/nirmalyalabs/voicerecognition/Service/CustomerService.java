package com.nirmalyalabs.voicerecognition.Service;

import java.util.List;

import com.nirmalyalabs.voicerecognition.Entity.Customer;



public interface CustomerService {

	
	public Customer saveCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer GetCustomerByID(Long id);

	public List<Customer> GetCustomerByName(String custname);

	public void DeleteCustomerByID(Long id);
	
}
