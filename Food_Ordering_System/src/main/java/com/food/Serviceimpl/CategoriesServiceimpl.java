package com.food.Seviceimpl;
import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import com.Util.HibernateUtil;
import com.food.entity.Categories;
import com.food.service.CategoriesService;

public class CategoriesServiceimpl implements CategoriesService{
	Scanner sc=new Scanner(System.in);
	public Categories createCategories(Categories categories) {
		try(Session session=HibernateUtil.getSession()) {
			
			session.beginTransaction();
			session.save(categories);
			session.getTransaction().commit();
			return categories;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	public List<Categories> getAllCategories() {
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all students data
			Query<Categories> query=session.createQuery("FROM Categories_Details");
			List<Categories> categoriesList=query.list();
			return categoriesList;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}


	public Categories getCategories(String catID) {
		
			try(Session session=HibernateUtil.getSession()) {
					
				Categories categories=session.get(Categories.class, catID);
					return categories;
				}
				catch (HibernateException e) {
					System.out.println(e);
				}
				catch (Exception e) {
					System.out.println(e);
				}
				
				return null;
			}

	

	public Categories updateCategories(String catId, Categories categories) {
		try(Session session=HibernateUtil.getSession()) {
			Categories category=session.get(Categories.class, catId);
				session.beginTransaction();
				
				category.setID(catId);
				category.setVeg(categories.getVeg());
				category.setNon_Veg(categories.getNon_Veg());
				
				
				session.saveOrUpdate(category);
				session.getTransaction().commit();
				return category;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public String deleteCategories(String id) {
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Categories categories=session.get(Categories.class, id);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(categories);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(categories);//data will remove from session Cache
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
