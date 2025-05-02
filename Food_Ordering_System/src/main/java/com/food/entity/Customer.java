package com.food.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="Customer_Details")
public class Customer {
	@Id
	@Column(name="CustomerID",length=10)
	private String CustomerID;
	
	@Column(name="ContactNo",length=20)
	private String ContactNo;
	
	@Column(name="Name",length=30)
	private String Name;
	
	@Column(name="Email_ID",length=30)
	private String Email_ID;
	
	@Column(name="Address",length=30)
	private String Address;

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
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

	public String getEmail_ID() {
		return Email_ID;
	}

	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}

	public Customer(String customerID, String contactNo, String name,String email_ID,String address) {
		super();
		CustomerID = customerID;
		ContactNo = contactNo;
		Name = name;
		Email_ID = email_ID;
		Address=address;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", ContactNo=" + ContactNo + ", Name=" + Name + ", Email_ID="
				+ Email_ID + ", Address=" + Address + "]";
	}


	


	
	
	
	}
