package com.nirmalyalabs.voicerecognition.Service;

import java.util.List;

import com.nirmalyalabs.voicerecognition.Entity.ops;

public interface opsService {

	public List<ops> getAllOrders();
	public List<ops> getAllOrdersByOrderId(long orderId);

	public long saveOrder(List<ops> allitems, long custid);

	public Boolean validateOrderItems(List<ops> allitems);

}
