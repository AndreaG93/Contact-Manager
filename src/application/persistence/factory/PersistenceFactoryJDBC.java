package application.persistence.factory;

import application.persistence.PersistenceAddress;
import application.persistence.PersistenceCustomer;
import application.persistence.jdbc.PersistenceAddressJDBC;
import application.persistence.jdbc.PersistenceCustomerJDBC;

/**
 * This class provides some function to manage a JDBC based persistence system.
 * 
 * @author Andrea Graziani
 * @version 1.0
 */
public class PersistenceFactoryJDBC extends PersistenceFactory {

	@Override
	public PersistenceAddress getPersistenceAddress() {
		return new PersistenceAddressJDBC();
	}

	@Override
	public PersistenceCustomer getPersistenceCustomer() {
		return new PersistenceCustomerJDBC();
	}
}