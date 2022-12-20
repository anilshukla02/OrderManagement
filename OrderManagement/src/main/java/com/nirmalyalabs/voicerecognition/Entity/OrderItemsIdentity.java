package com.nirmalyalabs.voicerecognition.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemsIdentity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "order_id", nullable = false)
	private long orderId;

	@Column(name = "item_id", nullable = false)
	private long itemId;

	public OrderItemsIdentity() {
	}

	public OrderItemsIdentity(long orderId, long itemId) {

		this.orderId = orderId;
		this.itemId = itemId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemsIdentity other = (OrderItemsIdentity) obj;
		return Objects.equals(itemId, other.itemId) && orderId == other.orderId;
	}

	@Override
	public String toString() {
		return "OrderItemsIdentity [orderId=" + orderId + ", itemId=" + itemId + "]";
	}

}
