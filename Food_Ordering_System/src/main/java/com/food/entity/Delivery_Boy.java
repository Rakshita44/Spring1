package com.food.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DeliveryBoy_Details")
public class Delivery_Boy {
	@Id
	@Column(name="DeliveryBoy_ID",length=10)
	private String DeliveryBoy_ID;
	
	@Column(name="ContactNo",length=20)
	private String ContactNo;
	
	@Column(name="Name",length=30)
	private String Name;

	public Delivery_Boy() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*@OneToMany
	@JoinColumn(name="OrderID")
	private Orders orders;
	*/
	public Delivery_Boy(String deliveryID, String contactNo, String name) {
		super();
		DeliveryBoy_ID = deliveryID;
		ContactNo = contactNo;
		Name = name;
	}

	public String getDeliveryBoy_ID() {
		return DeliveryBoy_ID;
	}

	public void setDeliveryBoy_ID(String deliveryID) {
		DeliveryBoy_ID = deliveryID;
	}

	public String getContactNo() {
		return ContactNo;
	}

	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Delivery_Boy [DeliveryBoy_ID=" + DeliveryBoy_ID + ", ContactNo=" + ContactNo + ", Name=" + Name + "]";
	}

	
	

	
	
}
