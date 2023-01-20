package com.nirmalyalabs.voicerecognition.Service.Impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.nirmalyalabs.voicerecognition.Entity.Ordermaster;
import com.nirmalyalabs.voicerecognition.Entity.ops;
import com.nirmalyalabs.voicerecognition.Repository.opsRepository;
import com.nirmalyalabs.voicerecognition.Service.ItemsService;
import com.nirmalyalabs.voicerecognition.Service.OrdermasterService;
import com.nirmalyalabs.voicerecognition.Service.opsService;
import com.nirmalyalabs.voicerecognition.Utilities.General.GeneralUtilities;

@Service
public class opsServiceImpl implements opsService {

	@Autowired
	opsRepository opsRepo;

	@Autowired
	OrdermasterService ordermasterService;

	@Autowired
	ItemsService itemsService;

	@Override
	public List<ops> getAllOrders() {

		return opsRepo.findAll();
	}

	@Override
	public long saveOrder(List<ops> allitems, long custid) {
//	public List<ops> saveOrder(List<ops> allitems, long custid) {
		Ordermaster ordermaster = new Ordermaster(custid);
		ordermaster.setOrderId(allitems.get(0).getOrderItemsIdentity().getOrderId());

		java.sql.Date currdate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		ordermaster.setOrderDate(currdate);
		
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		ordermaster.setCreatorUserId(username);

		long orderid = ordermasterService.saveOrder(ordermaster);

		for (ops orderitem : allitems) {
			orderitem.getOrderItemsIdentity().setOrderId(orderid);
		}

		opsRepo.saveAll(allitems);
		return orderid;
	}

	@Override
	public Boolean validateOrderItems(List<ops> allitems) {

		Boolean HasAllvaidItems = true;
		// update Item Id based on Item Description. If item not found then Item Id
		// is set to -1
		for (ops orderitem : allitems) {
			long itemcd = itemsService.GetItemByName(orderitem.getItemName());
			orderitem.getOrderItemsIdentity().setItemId(itemcd);
			if (itemcd == -1)
				HasAllvaidItems = false;

		}

		return HasAllvaidItems;
	}

	@Override
	public List<ops> getAllOrdersByOrderId(long orderId) {
		return opsRepo.findByOrderItemsIdentityOrderId(orderId);
		
	}

}
