package test.other;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import org.junit.jupiter.api.Test;

import application.entity.customer.Customer;
import application.entity.telephone_number.TelephoneNumber;
import application.entity.telephone_number.TelephoneNumberType;

public class JUnitDatabaseTestHibernateAccess {

	private SessionFactory factory = null;

/*
	@Test
	public void testSessionFactory() { 
		try(Session session = SessionUtil.getSession()) { 
			assertNotNull(session); 
		} 
	}





	public void update(Session pSession, Customer pCustomer) { 


		Transaction mTransaction = null;
		
		try { 

			mTransaction = pSession.beginTransaction(); 			
			pSession.update(pCustomer);
			mTransaction.commit(); 
		} catch (Exception e) {
			mTransaction.rollback();	
		}

	}
	
	
	public void update(Customer pCustomer) { 


		Transaction mTransaction = null;
		
		try { 
			Session mSession = SessionUtil.getSession();	
			mTransaction = mSession.beginTransaction(); 			
			mSession.update(pCustomer);
			mTransaction.commit(); 
		} catch (Exception e) {
			mTransaction.rollback();	
		}

	}




	public Serializable insert(Customer pCustomer) { 


		Transaction mTransaction = null;
		Serializable mIdentifier = null;

		try { 

			Session mSession = SessionUtil.getSession();	
			mTransaction = mSession.beginTransaction(); 			
			mIdentifier = mSession.save(pCustomer);
			mTransaction.commit(); 
		} catch (Exception e) {
			mTransaction.rollback();
			return null;
		}

		return mIdentifier;	
	}


	public Serializable insert(Session pSession, Customer pCustomer) { 


		Transaction mTransaction = null;
		Serializable mIdentifier = null;

		try { 

			mTransaction = pSession.beginTransaction(); 			
			mIdentifier = pSession.save(pCustomer);
			mTransaction.commit(); 
		} catch (Exception e) {
			mTransaction.rollback();
			return null;
		}

		return mIdentifier;	
	}

	public Customer get(Session pSession, int pId) { 

		try { 
			Query<Customer> mQuery = pSession.createQuery("FROM Customer c "
					+ "left join fetch c.telephoneNumbers tel "
					+ "WHERE c.customer_id=:customer_id", Customer.class); 
			mQuery.setParameter("customer_id", pId); 

			return (Customer) mQuery.uniqueResult();    
		} catch (Exception e) {
			// TODO: handle exception
		}   
		return null;
	}
	

	public Customer get(int pId) { 

		try(Session mSession = SessionUtil.getSession()) { 
			Query<Customer> mQuery = mSession.createQuery("FROM Customer WHERE customer_id=:customer_id", Customer.class); 
			mQuery.setParameter("customer_id", pId); 

			return (Customer) mQuery.uniqueResult();    
		}   
	}


	public List<Customer> get(String pName, String pSurname) { 

		try(Session mSession = SessionUtil.getSession()) { 
			Query<Customer> mQuery = mSession.createQuery("FROM Customer WHERE customer_name=:customer_name", Customer.class); 
			mQuery.setParameter("customer_name", pName); 

			return (List<Customer>) mQuery.list();   
		}   
	}







	@Test
	public void hibernateInsertTest() {

 

		

		Customer mCustomer = new Customer();
		mCustomer.setName("Andrea");
		mCustomer.setSurname("Graziani");

		TelephoneNumber mTelephoneNumber1 = new TelephoneNumber("3337832451", TelephoneNumberType.Home);

		mCustomer.getTelephoneNumbers().add(mTelephoneNumber1);


		int mId = (int) insert(mCustomer);
		mCustomer = get(mId);

		assertEquals(mId, mCustomer.getId());
		assertEquals("Andrea", mCustomer.getName());
		assertEquals("Graziani", mCustomer.getSurname());
		assertEquals("3337832451", mCustomer.getTelephoneNumbers().get(0).getNumber());
		assertEquals(TelephoneNumberType.Home, mCustomer.getTelephoneNumbers().get(0).getType());


		mCustomer.getTelephoneNumbers().get(0).setNumber("444444");
		
	
		
		update(mCustomer);
		
		mCustomer = get(mId);
		
		if(!Hibernate.isInitialized(mCustomer.getTelephoneNumbers()))
			System.out.println("NON INIT");
		
		//SessionUtil.closeSession();
		//mSession = SessionUtil.getSession();	

		
		SessionUtil.closeSession();
		mCustomer = get(mId);
		assertEquals("444444", mCustomer.getTelephoneNumbers().get(0).getNumber());














	}
*/

}
