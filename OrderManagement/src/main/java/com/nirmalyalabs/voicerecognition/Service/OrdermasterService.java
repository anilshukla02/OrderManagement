package com.nirmalyalabs.voicerecognition.Service;

import java.util.List;

import com.nirmalyalabs.voicerecognition.Entity.Ordermaster;

public interface OrdermasterService {

	public long saveOrder(Ordermaster order);
	public List<Ordermaster> getAllOrders();
	public List<Ordermaster> GetOrdermasterByCustid(long custid);
	public Ordermaster GetOrdermasterById(long orderId);

}
