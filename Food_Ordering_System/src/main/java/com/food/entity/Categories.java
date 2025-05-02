package com.food.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categories_Details")
public class Categories {
	@Id
	@Column(name="ID",length=10)
	private String ID;
	@Column(name="Veg",length=10)
	private String Veg;
	@Column(name="Non_Veg",length=20)
	private String Non_Veg;
	public Categories() {
		super();
	}
	public Categories(String veg, String non_Veg,String id) {
		super();
		ID=id;
		Veg = veg;
		Non_Veg = non_Veg;
	}
	public String getVeg() {
		return Veg;
	}
	public void setVeg(String veg) {
		Veg = veg;
	}
	public String getNon_Veg() {
		return Non_Veg;
	}
	public void setNon_Veg(String non_Veg) {
		Non_Veg = non_Veg;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "Categories [ID=" + ID + ", Veg=" + Veg + ", Non_Veg=" + Non_Veg + "]";
	}

}
