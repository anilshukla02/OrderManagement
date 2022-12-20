package com.nirmalyalabs.voicerecognition.Entity;

public class CustomerDTO {

	private long custId;
	private String custname;
	private Boolean custValid;
	
	
	
	public CustomerDTO() {
	}

	/*
	public List<CustomerDTO> getAllCustomers() {
		
		this.customers =customerService.getAllCustomers();
		

		return allCustomers;
	}
	*/

	public long getCustId() {
		return custId;
	}


	public void setCustId(long custId) {
		this.custId = custId;
	}


	public String getCustname() {
		return custname;
	}


	public void setCustname(String custname) {
		this.custname = custname;
	}


	public Boolean getCustValid() {
		return custValid;
	}

	public void setCustValid(Boolean custValid) {
		this.custValid = custValid;
	}
	
}
