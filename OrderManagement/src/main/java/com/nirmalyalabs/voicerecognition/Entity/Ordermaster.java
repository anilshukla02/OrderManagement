package com.nirmalyalabs.voicerecognition.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_master")
public class Ordermaster {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false)
	private long orderId;
	@Column(name = "customer_id", nullable = false)
	private long custid;
	private String creatorUserId;

	@CreationTimestamp
	private Date orderDate;

	public Ordermaster() {
	}

	public Ordermaster(long custid) {
		this.custid = custid;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}


	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date date) {
		this.orderDate = date;
	}

	public String getCreatorUserId() {
		return creatorUserId;
	}

	public void setCreatorUserId(String creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	@Override
	public String toString() {
		return "Ordermaster [orderId=" + orderId + ", custid=" + custid + ", creatorUserId=" + creatorUserId
				+ ", orderDate=" + orderDate + "]";
	}

}
