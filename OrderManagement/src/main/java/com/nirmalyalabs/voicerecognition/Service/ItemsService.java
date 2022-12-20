package com.nirmalyalabs.voicerecognition.Service;

import java.util.List;

import com.nirmalyalabs.voicerecognition.Entity.ItemMaster;

public interface ItemsService {

	public ItemMaster saveItem(ItemMaster item);

	public List<ItemMaster> getAllItems();

	public ItemMaster GetItemByID(Long id);

	public long GetItemByName(String itemName);

	public void DeleteItemByID(Long id);

}
