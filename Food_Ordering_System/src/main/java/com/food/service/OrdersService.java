package com.food.service;
import java.util.List;
import com.food.entity.Orders;

public interface OrdersService {
	Orders createOrders(Orders orders);	
	Orders getOrders(String orderID);
	List<Orders> getAllOrders();
	Orders updateOrders(String oId, Orders order);
	String deleteOrders(String id);

}
