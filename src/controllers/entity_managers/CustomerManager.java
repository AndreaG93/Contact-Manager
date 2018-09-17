package controllers.entity_managers;

import controllers.dao.CustomerDAO;
import controllers.dao.factory.DAOFactory;
import controllers.validators.ValidatorFactory;
import entity.customer.Customer;

public class CustomerManager {

	CustomerDAO customerDAO;

	/**
	 * Constructs a newly allocated {@code CustomerManager} object.
	 */
	public CustomerManager() {
		this.customerDAO = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE).getCustomerDAO();
	}

	/**
	 * This method is used to validate and save a new {@code Customer} object into
	 * database.
	 * 
	 * @param obj
	 *            - Represents a {@code Customer} object.
	 * @throws Exception
	 */
	public void insertCustomer(Customer obj) throws Exception {

		/* Validation data. */
		ValidatorFactory.validate(obj);

		/* Saving data into database... */
		this.customerDAO.insert(obj);
	}

	/**
	 * This method is used to validate and update a given {@code Customer} object
	 * into database.
	 * 
	 * @param obj
	 *            - Represents a {@code Customer} object.
	 * @throws Exception
	 */
	public void updateCustomer(Customer obj) throws Exception {

		/* Validation data. */
		ValidatorFactory.validate(obj);

		/* Update data into database... */
		this.customerDAO.update(obj);
	}

	/**
	 * This method is used to delete a given {@code Customer} object from database.
	 * 
	 * @param obj
	 *            - Represents a {@code Customer} object.
	 */
	public void deleteCustomer(Customer obj) {
		this.customerDAO.delete(obj);
	}

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

}
