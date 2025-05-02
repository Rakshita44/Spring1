package com.food.Seviceimpl;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.Util.HibernateUtil;
import com.food.entity.Food;
import com.food.service.FoodService;

public class FoodServiceimpl implements FoodService{
	Scanner sc=new Scanner(System.in);
	@Override
	public Food createFood(Food food) {
	
			try(Session session=HibernateUtil.getSession()) {
				
				session.beginTransaction();
				session.save(food);
				session.getTransaction().commit();
				return food;
				
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
	public Food getFood(String foodID) {
		try(Session session=HibernateUtil.getSession()) {
			
			Food food=session.get(Food.class, foodID);
				return food;
				
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
	public List<Food> getFoodByCategoryId(String categoryId) {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Food> query=session.createQuery("FROM Food");
			List<Food> foodList=query.list();
			return foodList;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}*/
	@Override
	public List<Food> getAllFoods() {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Food> query=session.createQuery("FROM Customer");
			List<Food> foodList=query.list();
			return foodList;
			
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
	public Food updateFood(String fId, Food fd) {
		try(Session session=HibernateUtil.getSession()) {
			Food food=session.get(Food.class, fId);
				session.beginTransaction();
				
				food.setFoodID(fId);
				food.setPrice(fd.getPrice());
				food.setFoodName(fd.getFoodName());
				food.setDescription(fd.getDescription());
				food.setQuantity(fd.getQuantity());
				
				session.saveOrUpdate(food);
				session.getTransaction().commit();
				return food;
			
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
	public String deleteFood(String id) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Food food=session.get(Food.class, id);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(food);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(food);//data will remove from session Cache
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
