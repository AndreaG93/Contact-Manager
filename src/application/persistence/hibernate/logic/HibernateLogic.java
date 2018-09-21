package application.persistence.hibernate.logic;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import application.entity.customer.Customer;

public class HibernateLogic {
	
	
	
	public static Serializable insert(Object pObject) { 

		Transaction mTransaction = null;
		Serializable mIdentifier = null;

		try { 

			Session mSession = HibernateSessionUtility.getSession();	
			mTransaction = mSession.beginTransaction(); 			
			mIdentifier = mSession.save(pObject);
			mTransaction.commit(); 
		} catch (Exception e) {
			mTransaction.rollback();
			return null;
		}

		return mIdentifier;	
	}
	
	
	public static void update(Object pObject) { 


		Transaction mTransaction = null;
		
		try { 
			Session mSession = HibernateSessionUtility.getSession();	
			mTransaction = mSession.beginTransaction(); 			
			mSession.update(pObject);
			mTransaction.commit(); 
		} catch (Exception e) {
			if(mTransaction != null)
			mTransaction.rollback();	
		}

	}
	
	public static Object getQueryUniqueResult(String pQuery) { 

		try { 
			Session mSession = HibernateSessionUtility.getSession();
			@SuppressWarnings("unchecked")
			Query<Customer> mQuery = mSession.createQuery(pQuery);

			return mQuery.uniqueResult();    
		} catch (Exception e) {
			return null;
		}   		
	}


	public static void delete(Object pObject) {
		Transaction mTransaction = null;
	     try { 
	    	 
	    	 Session mSession = HibernateSessionUtility.getSession();
	         mTransaction = mSession.beginTransaction(); 
	         
	         mSession.delete(pObject); 
	         mTransaction.commit(); 
	     } catch (Exception e) {
	    	 if(mTransaction != null)
	    		 mTransaction.rollback();	
		}
	  
		
	}

}
