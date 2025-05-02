package com.food.Daoimp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.Util.HibernateUtil;
import com.food.Dao.CustomerDao;
import com.food.entity.Admin;
import com.food.entity.Customer;
import com.food.entity.Food;
import com.food.entity.Orders;
import com.food.exception.ResourceNotFoundException;


public class CustomerDaoImpl implements CustomerDao{
	 Scanner sc=new Scanner(System.in);
		@Override
		public Customer createCustomer(Customer customer) {
			try(Session session=HibernateUtil.getSession()) {
				
				session.beginTransaction();
				session.save(customer);
				session.getTransaction().commit();
				return customer;
				
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
			return null;
		}

		@Override
		public List<Customer> getAllCustomer() {
			try(Session session=HibernateUtil.getSession()) {
				
				//execute HQL query to retrieve all students data
				Query<Customer> query=session.createQuery("FROM Customer");
				List<Customer> customerList=query.list();
				return customerList;
				
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
			return null;
		}

/*		@Override
		public Orders OrdersCustomer(Orders orders) {
			try(Session session=HibernateUtil.getSession()) {
				session.beginTransaction();
				session.save(orders);
				session.getTransaction().commit();
				return orders;
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}
*/
		@Override
		public Customer getCustomer(String customerID) {
			
				try(Session session=HibernateUtil.getSession()) {
						
					Customer customer=session.get(Customer.class, customerID);
						return customer;
					}
					catch (HibernateException e) {
						System.out.println(e);
					}
					catch (Exception e) {
						System.out.println(e);
					}
					
					return null;
				}

	/*	@Override
		public List<Orders> getOrdersDetailsByCustomerId(String customerId) {
			try(Session session=HibernateUtil.getSession()) {
				Customer food=session.get(Customer.class, customerId);
				if(food!=null)
				{
					List<Orders> orders=new ArrayList<>();
					//execute HQL query to retrieve all Food data
					Query<Orders> query=session.createQuery("FROM Orders");
					List<Orders> ordersList=query.list();
					for(Orders e:ordersList)
					{
						if(e.getFood().equals(food))
							orders.add(e);
					}
					return orders;
				}
				else
				{
					throw new Exception("Course id is not found");
				}
			
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return null;
			}
*/
		@Override
		public Customer updatecustomer(String customerID,Customer updatedCustomer) {
			try(Session session=HibernateUtil.getSession()) {
				Customer customer=session.get(Customer.class, customerID);
					session.beginTransaction();
					
					customer.setCustomerID(customerID);
					customer.setContactNo(updatedCustomer.getContactNo());
					customer.setName(updatedCustomer.getName());
					customer.setEmail_ID(updatedCustomer.getEmail_ID());
					customer.setAddress(updatedCustomer.getAddress());
					
					session.saveOrUpdate(customer);
					session.getTransaction().commit();
					return customer;
				
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return null;
		}

		@Override
		public String deleteCustomer(String customerID) {
			String message=null;
			try(Session session=HibernateUtil.getSession()) {
				Customer customer=session.get(Customer.class, customerID);
					session.beginTransaction();
					System.out.println("Are you sure  you want to delete?");
					String status=sc.next();
					if(status.equalsIgnoreCase("yes"))
					{
						session.delete(customer);//data will be deleted from DB
						session.getTransaction().commit();
						session.evict(customer);//data will remove from session Cache
						message="Object is deleted";
						
					}else
					{
						message="User wants to retain this object!!";
					}
					
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			return message;

}
}
