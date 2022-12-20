package com.nirmalyalabs.voicerecognition.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.Ordermaster;
import com.nirmalyalabs.voicerecognition.Repository.OrderMasterRepository;
import com.nirmalyalabs.voicerecognition.Service.OrdermasterService;

@Service
public class OrdermasterServiceImpl implements OrdermasterService {

	@Autowired
	OrderMasterRepository orderMasterRepository;

	@Override
	public long saveOrder(Ordermaster order) {

		Ordermaster ordermaster = orderMasterRepository.save(order);
		return ordermaster.getOrderId();

	}

	@Override
	public List<Ordermaster> GetOrdermasterByCustid(long custid) {
		return orderMasterRepository.findByCustid(custid);
	}

	@Override
	public List<Ordermaster> getAllOrders() {
		return orderMasterRepository.findAll();
	}

	@Override
	public Ordermaster GetOrdermasterById(long orderId) {
		
		return orderMasterRepository.findById(orderId).get();
	}

}
