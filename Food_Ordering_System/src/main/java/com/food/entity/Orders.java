package com.food.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderPlace_Details")

public class Orders {
	@Id
	@Column(name="OrderID",length=10)
	private String OrderID;
	@Column(name="OrderDate",length=20)
	private String OrderDate;
	@Column(name="OrderStatus",length=20)
	private String OrderStatus;
	@Column(name="DeliveryDate",length=20)
	private String DeliveryDate;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Orders(String orderID, String orderDate, String orderStatus, String deliveryDate) {
		super();
		OrderID = orderID;
		OrderDate = orderDate;
		OrderStatus = orderStatus;
		DeliveryDate = deliveryDate;
	}
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	public String getDeliveryDate() {
		return DeliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		DeliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return "Orders [OrderID=" + OrderID + ", OrderDate=" + OrderDate + ", OrderStatus=" + OrderStatus
				+ ", DeliveryDate=" + DeliveryDate + "]";
	}
	public void put(String orderID2, Orders orders) {
		// TODO Auto-generated method stub
		
	}

	
}
