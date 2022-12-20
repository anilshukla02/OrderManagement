package com.nirmalyalabs.voicerecognition.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_items")
public class ops {

	@EmbeddedId
	OrderItemsIdentity orderItemsIdentity;

	@Column(name = "ordered_ItemDesc", nullable = false)
	String ItemName;

	@Column(name = "ordered_qty", nullable = false)
	private int qty;
	private String comments;

	public OrderItemsIdentity getOrderItemsIdentity() {
		return orderItemsIdentity;
	}

	public void setOrderItemsIdentity(OrderItemsIdentity orderItemsIdentity) {
		this.orderItemsIdentity = orderItemsIdentity;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "ops [orderItemsIdentity=" + orderItemsIdentity + ", ItemName=" + ItemName + ", qty=" + qty
				+ ", comments=" + comments + "]";
	}

}
