package com.food.Seviceimpl;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.Util.HibernateUtil;
import com.food.entity.Orders;
import com.food.service.OrdersService;

public class OrdersServiceimpl implements OrdersService{
	Scanner sc=new Scanner(System.in);
	@Override
	public Orders createOrders(Orders orders) {
	
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

	@Override
	public Orders getOrders(String orderID) {
		try(Session session=HibernateUtil.getSession()) {
			
			Orders payment=session.get(Orders.class, orderID);
				return payment;
				
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
	public List<Orders> getAllOrders() {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Orders> query=session.createQuery("FROM Orders_Details");
			List<Orders> orderList=query.list();
			return orderList;
			
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
	public Orders updateOrders(String oId, Orders order) {
		try(Session session=HibernateUtil.getSession()) {
			Orders order1=session.get(Orders.class, oId);
				session.beginTransaction();
				
				order1.setOrderID(oId);
				order1.setOrderDate(order.getOrderDate());
				order1.setOrderStatus(order.getOrderStatus());
				order1.setDeliveryDate(order.getDeliveryDate());
				session.saveOrUpdate(order1);
				session.getTransaction().commit();
				return order1;
			
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
	public String deleteOrders(String id) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Orders payment=session.get(Orders.class, id);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(payment);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(payment);//data will remove from session Cache
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
