package com.nirmalyalabs.voicerecognition.Entity;

import java.util.ArrayList;

public class ItemsListDTO {

	private ArrayList<ItemMaster> items;

	public ItemsListDTO() {
		items = new ArrayList<ItemMaster>();
	}

	public ItemsListDTO(ArrayList<ItemMaster> items) {
		this.items = items;
	}

	public ArrayList<ItemMaster> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemMaster> items) {
		this.items = items;
	}

	public void addItems(ItemMaster itemMaster) {
		this.items.add(itemMaster);
	}

}
