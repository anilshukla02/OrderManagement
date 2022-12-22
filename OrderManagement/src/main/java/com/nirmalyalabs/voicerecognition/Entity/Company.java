package com.nirmalyalabs.voicerecognition.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class Company {

	@Id
	String companyId;
	String companyName;
	String licenceNo;
	Date licenceValidity;
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public Date getLicenceValidity() {
		return licenceValidity;
	}
	public void setLicenceValidity(Date licenceValidity) {
		this.licenceValidity = licenceValidity;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", licenceNo=" + licenceNo
				+ ", licenceValidity=" + licenceValidity + "]";
	}
	
	
	
}
