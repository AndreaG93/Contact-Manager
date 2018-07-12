package test.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import controllers.dao.CustomerDAO;
import controllers.dao.factory.DAOFactory;
import controllers.entity_managers.CustomerManager;
import entity.customer.Customer;
import entity.customer.Title;
import entity.telephone_number.TelephoneNumber;

public class HibernateCustomerDAOTest {

	/**
	 * This method is used to get DAO class.
	 * 
	 * @return A {@code CustomerDAO} object.
	 */
	public static CustomerDAO getCustomerDAO() {
		/* Get 'Hibernate' DAO factory. */
		DAOFactory myFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);
		assertNotNull(myFactory);

		/* Get DAO class. */
		CustomerDAO myDAO = myFactory.getCustomerDAO();
		assertNotNull(myDAO);

		return myDAO;
	}

	public static void initialization() throws Exception {
		/* Allocation data. */
		CustomerManager myCustomerManager = new CustomerManager();

		Customer myCustomer_1 = new Customer();
		myCustomer_1.setTitle(Title.Mr);
		myCustomer_1.setName("Andrea");
		myCustomer_1.setSurname("Graziani");

		Customer myCustomer_2 = new Customer();
		myCustomer_2.setTitle(Title.Mr);
		myCustomer_2.setName("Luca");
		myCustomer_2.setSurname("Atturo");

		Customer myCustomer_3 = new Customer();
		myCustomer_3.setTitle(Title.Mr);
		myCustomer_3.setName("Roberto");
		myCustomer_3.setSurname("Capanelli");

		Customer myCustomer_4 = new Customer();
		myCustomer_4.setTitle(Title.Mr);
		myCustomer_4.setName("Alessandro");
		myCustomer_4.setSurname("La Selva");

		/* Inserting data into database. */
		myCustomerManager.insertCustomer(myCustomer_1);
		myCustomerManager.insertCustomer(myCustomer_2);
		myCustomerManager.insertCustomer(myCustomer_3);
		myCustomerManager.insertCustomer(myCustomer_4);

	}

	@Test
	public void test_initialization() {
		
		/* Inserting data into database. */
		try {
			initialization();
		} catch (Exception e1) {
			e1.printStackTrace();
			fail();
		}
	}

	@Test
	public void test_getCount() {
		CustomerDAO myDAO = getCustomerDAO();
		assertEquals(4, myDAO.getCount());
	}

	@Test
	public void test_telephoneNumbers() {

		/* Allocation data. */
		CustomerManager myCustomerManager = new CustomerManager();

		/* Getting "Customer" object. */
		Customer obj = myCustomerManager.getCustomerDAO().get(1);
		assertNotNull(obj);

		/* Add some telephone numbers */
		TelephoneNumber x = new TelephoneNumber("54534432", null);
		obj.getTelephoneNumbers().add(x);

		/* Update data. */
		try {
			myCustomerManager.updateCustomer(obj);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

}
