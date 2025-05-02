package com.food.service;
import java.util.List;
import com.food.entity.Delivery_Boy;

public interface DeliveryBoyService {
	Delivery_Boy createDelivery_Boy(Delivery_Boy Delivery_Boy);	
	Delivery_Boy getDelivery_Boy(String Delivery_BoyID);
	List<Delivery_Boy> getAllDelivery_Boys();
	Delivery_Boy updateDeliveryBoy(String dbId, Delivery_Boy dBoy);
	String deleteDeliveryBoy(String id);
}
