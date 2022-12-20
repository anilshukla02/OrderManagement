package com.nirmalyalabs.voicerecognition.Entity;

import java.util.ArrayList;
import java.util.List;

public class opsDTO {

	private List<ops> orderedItemlist;
	long custId;
	String customername;

	public opsDTO() {
		orderedItemlist = new ArrayList<ops>();
		
	}

	public opsDTO(List<ops> orderedItemlist, long custId) {
		this.orderedItemlist = orderedItemlist;
		this.custId = custId;
	}

	public List<ops> getOrderedItemlist() {
		return orderedItemlist;
	}

	public void setOrderedItemlist(List<ops> orderedItemlist) {
		this.orderedItemlist = orderedItemlist;
	}


	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	
	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public void addOrderItem(ops orderItem) {
		this.orderedItemlist.add(orderItem);
	}


	@Override
	public String toString() {
		return "opsDTO [orderedItemlist=" + orderedItemlist + ", custId=" + custId + "]";
	}

}
