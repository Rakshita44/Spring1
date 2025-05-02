package com.food.Dao;
import java.util.List;
import com.food.entity.Admin;
import com.food.entity.Customer;

public interface AdminDao {
	Admin createAdmin(Admin admin);	
	List<Admin> getAllAdmin();
	//Customer AdminCustomer(Customer customer);
	Admin getAdmin(String adminID);
	//List<Customer> getEnrollmentDetailsByCourseId(String courseId);
	Admin updateAdmin(String adminID,Admin updatedAdmin);
	String deleteAdmin(String adminID);

}
