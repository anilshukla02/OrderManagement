package com.nirmalyalabs.voicerecognition.Entity;

public class OrderMasterDTO {
	
	Ordermaster ordermaster;
	private String custname;
	
	public OrderMasterDTO() {
	}
	public Ordermaster getOrdermaster() {
		return ordermaster;
	}
	public void setOrdermaster(Ordermaster ordermaster) {
		this.ordermaster = ordermaster;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}

}
