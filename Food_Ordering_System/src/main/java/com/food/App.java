package com.food;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.Util.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {   
    	//get sessionFactory
    			SessionFactory factory=HibernateUtil.getSessionFactory();
    			//create a session(connection)
    			Session session=factory.openSession();

    			//Begin a Transaction
    			Transaction tx=session.beginTransaction();
    			tx.commit();
    			session.close();
    			factory.close();

    }


   	
    
}
