package com.food.Dao;
import java.util.List;
import com.food.entity.Orders;

public interface OrdersDao {
	Orders createOrders(Orders orders);	
	Orders getOrders(String orderID);
	List<Orders> getAllOrders();
	Orders updateOrders(String oId, Orders order);
	String deleteOrders(String id);
}
