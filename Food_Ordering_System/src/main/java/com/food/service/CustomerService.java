package com.food.service;
import java.util.List;
import com.food.entity.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer);	
	List<Customer> getAllCustomer();
	//Orders OrdersCustomer(Orders orders);
	Customer getCustomer(String customerID);
	//List<Orders> getOrdersDetailsByCustomerId(String customerId);
	Customer updatecustomer(String customerID,Customer updatedCustomer);
	String deleteCustomer(String customerID);
}

