package com.food.Dao;
import java.util.List;

import com.food.entity.Customer;
import com.food.entity.Orders;

public interface CustomerDao {
	Customer createCustomer(Customer customer);	
	List<Customer> getAllCustomer();
	//Orders OrdersCustomer(Orders orders);
	Customer getCustomer(String customerID);
	//List<Orders> getOrdersDetailsByCustomerId(String customerId);
	Customer updatecustomer(String customerID,Customer updatedCustomer);
	String deleteCustomer(String customerID);
}
