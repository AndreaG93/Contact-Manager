package application.persistence;

import java.util.List;

import application.entity.customer.Customer;

/**
 * This class provides an interface to manage {@code Customer} object persistence.
 * 
 * @author Andrea Graziani
 * @version 1.0
 */
public interface PersistenceCustomer {

	/**
	 * This method is used to insert a {@code Customer} object into persistence system.
	 * 
	 * @param pCustomer - Represents a {@code Customer} object.
	 * @return An {@code int} value.
	 */
	public int insert(Customer pCustomer);

	/**
	 * This method is used to delete a {@code Customer} object from persistence system.
	 * 
	 * @param pCustomer - Represents a {@code Customer} object.
	 */
	public void delete(Customer pCustomer);

	/**
	 * This method is used to update a {@code Customer} object already saved in persistence system.
	 * 
	 * @param pCustomer - Represents a {@code Customer} object.
	 */
	public void update(Customer pCustomer);

	/**
	 * This method is used to get a {@code Customer} object stored in persistence system.
	 * 
	 * @param pCustomerIdentifier - Represents an {@code int} value.
	 */
	public Customer get(int pCustomerIdentifier);

	/**
	 * This method is used to get a pageable collection {@code Customer} object stored in persistence system.
	 * 
	 * @param pageSize - Represents an {@code int} value.
	 * @param pageNumber - Represents an {@code int} value.
	 * @return A {@code List<Customer>} object.
	 */
	public List<Customer> getPageableCollection(int pageSize, int pageNumber);

	/**
	 * This method is used to count all {@code Customer} object already saved in persistence system.
	 * 
	 * @return An {@code int} value.
	 */
	public long getCount();
}