package com.food.service;
import java.util.List;
import com.food.entity.Payment;

public interface PaymentService {
	Payment createPayment(Payment payment);	
	Payment getPayment(String paymentID);
	List<Payment> getAllPayments();
	Payment updatePayment(String pId, Payment pay);
	String deletePayment(String id);
}
