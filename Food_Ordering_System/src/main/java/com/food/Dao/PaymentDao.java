package com.food.Dao;
import java.util.List;
import com.food.entity.Payment;

public interface PaymentDao {
	Payment createPayment(Payment payment);	
	Payment getPayment(String paymentID);
	List<Payment> getAllPayments();
	Payment updatePayment(String pId, Payment pay);
	String deletePayment(String id);
}
