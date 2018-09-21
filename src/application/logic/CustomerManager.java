package application.logic;

import application.persistence.PersistenceCustomer;
import application.persistence.factory.PersistenceFactory;

public class CustomerManager {

	private static final String PERSISTENCE_TECHNOLOGY = PersistenceFactory.JDBC;

	/**
	 * This method is used to retrieve a {@code PersistenceCustomer} object.
	 * 
	 * @return A {@code PersistenceCustomer} object.
	 */
	public static PersistenceCustomer getPersistenceSystem() {
		try {
			return PersistenceFactory.getDAOFactory(PERSISTENCE_TECHNOLOGY).getPersistenceCustomer();
		} catch (Exception e) {
			return null;
		}
	}
}