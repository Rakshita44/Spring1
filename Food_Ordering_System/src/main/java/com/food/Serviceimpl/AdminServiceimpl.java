package com.food.Seviceimpl;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.Util.HibernateUtil;
import com.food.Daoimp.*;
import com.food.entity.*;
import com.food.service.Adminservice;

public class AdminServiceimpl implements Adminservice {
	Scanner sc=new Scanner(System.in);
	@Override
	public Admin createAdmin(Admin admin) {
		try(Session session=HibernateUtil.getSession()) {
			
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
			return admin;
			
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
	public List<Admin> getAllAdmin() {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Admin> query=session.createQuery("FROM Admin_Details");
			List<Admin> adminList=query.list();
			return adminList;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	/*@Override
	public Customer AdminCustomer(Customer customer) {
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
*/
	@Override
	public Admin getAdmin(String adminID) {
		
			try(Session session=HibernateUtil.getSession()) {
					
				Admin admin=session.get(Admin.class, adminID);
					return admin;
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
	public List<Customer> getCustomerDetailsByCustomerId(String customerId) {
		try(Session session=HibernateUtil.getSession()) {
			Customer cust=session.get(Customer.class, customerId);
			if(cust!=null)
			{
				List<Customer> orders=new ArrayList<>();
				//execute HQL query to retrieve all Food data
				Query<Customer> query=session.createQuery("FROM Customers");
				List<Customer> ordersList=query.list();
				for(Customer e:ordersList)
				{
					if(e.getCustomerID().equals(customerId))
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
	public Admin updateAdmin(String adminID,Admin updatedAdmin) {
		try(Session session=HibernateUtil.getSession()) {
			Admin admin=session.get(Admin.class, adminID);
				session.beginTransaction();
				
				admin.setAdminID(adminID);
				admin.setContactNo(updatedAdmin.getContactNo());
				admin.setName(updatedAdmin.getName());
				admin.setEmailAddress(updatedAdmin.getEmailAddress());
				
				session.saveOrUpdate(admin);
				session.getTransaction().commit();
				return admin;
			
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
	public String deleteAdmin(String adminID) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Admin admin=session.get(Admin.class, adminID);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(admin);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(admin);//data will remove from session Cache
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
