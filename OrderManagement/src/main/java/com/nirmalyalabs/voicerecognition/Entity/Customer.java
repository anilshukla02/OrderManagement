package com.nirmalyalabs.voicerecognition.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long custId;
	
	private String custname;
	private String billAddress;
	private String shipAddress;
	private Boolean custValid;
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
	public String getBillAddress() {
		return billAddress;
	}
	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	public Boolean getCustValid() {
		return custValid;
	}
	public void setCustValid(Boolean custValid) {
		this.custValid = custValid;
	}
	@Override
	public String toString() {
		return "customer [custId=" + custId + ", custname=" + custname + ", billAddress=" + billAddress
				+ ", shipAddress=" + shipAddress + ", custValid=" + custValid + "]";
	}
	


}
