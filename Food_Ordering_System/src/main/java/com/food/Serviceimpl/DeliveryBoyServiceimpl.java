package com.food.Seviceimpl;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.Util.HibernateUtil;
import com.food.entity.Delivery_Boy;
import com.food.service.DeliveryBoyService;

public class DeliveryBoyServiceimpl implements DeliveryBoyService {
	Scanner sc=new Scanner(System.in);
	@Override
	public Delivery_Boy createDelivery_Boy(Delivery_Boy Delivery_Boy) {
	
			try(Session session=HibernateUtil.getSession()) {
				
				session.beginTransaction();
				session.save(Delivery_Boy);
				session.getTransaction().commit();
				return Delivery_Boy;
				
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
	public Delivery_Boy getDelivery_Boy(String Delivery_BoyID) {
		try(Session session=HibernateUtil.getSession()) {
			
			Delivery_Boy Delivery_Boy=session.get(Delivery_Boy.class,Delivery_BoyID);
				return Delivery_Boy;
				
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
	public List<Delivery_Boy> getAllDelivery_Boys() {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Delivery_Boy> query=session.createQuery("FROM Delivery_Boy");
			List<Delivery_Boy> deliveryboyList=query.list();
			return deliveryboyList;
			
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
	public Delivery_Boy updateDeliveryBoy(String dbId, Delivery_Boy dBoy) {
		try(Session session=HibernateUtil.getSession()) {
			Delivery_Boy Db=session.get(Delivery_Boy.class,dbId);
				session.beginTransaction();
				
				Db.setDeliveryBoy_ID(dbId);
				Db.setContactNo(dBoy.getContactNo());
				Db.setName(dBoy.getName());
				
				
				session.saveOrUpdate(Db);
				session.getTransaction().commit();
				return Db;
			
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
	public String deleteDeliveryBoy(String id) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Delivery_Boy db=session.get(Delivery_Boy.class, id);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(db);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(db);//data will remove from session Cache
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
