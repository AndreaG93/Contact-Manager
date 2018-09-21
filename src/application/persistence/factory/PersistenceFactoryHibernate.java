package application.persistence.factory;

import application.persistence.PersistenceAddress;
import application.persistence.PersistenceCustomer;
import application.persistence.hibernate.PersistenceAddressHibernate;
import application.persistence.hibernate.PersistenceCustomerHibernate;

/**
 * This class provides some function to manage an Hibernate based persistence system.
 * 
 * @author Andrea Graziani
 * @version 1.0
 */
public class PersistenceFactoryHibernate extends PersistenceFactory {

	@Override
	public PersistenceAddress getPersistenceAddress() {
		return new PersistenceAddressHibernate();
	}

	@Override
	public PersistenceCustomer getPersistenceCustomer() {
		return new PersistenceCustomerHibernate();
	}
}