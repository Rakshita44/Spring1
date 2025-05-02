package com.food.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin_Details")

public class Admin {
	@Id
	@Column(name="AdminID",length=10)
	private String AdminID;
	
	@Column(name="Name",length=20)
	private String Name;
	
	@Column(name="ContactNo",length=20)
	private String ContactNo;
	
	@Column(name="EmailAddress",length=20)
	private String EmailAddress;
	
	public Admin() {
		super();
	}
	
	public Admin(String adminID, String name, String contactNo, String emailAddress) {
		super();
		AdminID = adminID;
		Name = name;
		ContactNo = contactNo;
		EmailAddress = emailAddress;
	}
	public String getAdminID() {
		return AdminID;
	}
	public void setAdminID(String adminID) {
		AdminID = adminID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "Admin [AdminID=" + AdminID + ", Name=" + Name + ", ContactNo=" + ContactNo + ", EmailAddress="
				+ EmailAddress + "]";
	}


	
	
	
}
