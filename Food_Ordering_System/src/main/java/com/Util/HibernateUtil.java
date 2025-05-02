package com.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.food.entity.Admin;
import com.food.entity.Categories;
import com.food.entity.Customer;
import com.food.entity.Delivery_Boy;
import com.food.entity.Food;
import com.food.entity.Orders;
import com.food.entity.Payment;

public class HibernateUtil {

	private final static SessionFactory sessionFactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory()
	{

		try {
			return new Configuration().configure("Hibernate.cfg.xml")
					.addAnnotatedClass(Admin.class)
					.addAnnotatedClass(Customer.class)
					.addAnnotatedClass(Food.class)
					.addAnnotatedClass(Orders.class)
					.addAnnotatedClass(Categories.class)
					.addAnnotatedClass(Payment.class)
					.addAnnotatedClass(Delivery_Boy.class)
					.buildSessionFactory();
			
		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession()
	{
	  return getSessionFactory().openSession(); //session opened
	}
		

}