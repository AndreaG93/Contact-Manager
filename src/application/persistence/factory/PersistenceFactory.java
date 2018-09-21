package application.persistence.factory;

import java.text.MessageFormat;

import application.persistence.PersistenceAddress;
import application.persistence.PersistenceCustomer;

/**
 * This class provides some function to build {@code PersistenceFactory} objects.
 * 
 * @author Andrea Graziani
 * @version 1.0
 */
public abstract class PersistenceFactory {

	public static final String HIBERNATE = "Hibernate";
	public static final String JDBC = "JDBC";

	/**
	 * This function returns a {@code PersistenceFactory} object that is used to manage persistence system.
	 *
	 * @param arg0 - Represents a {@code String} object.
	 * @return A {@code PersistenceFactory} object.
	 */
	public static PersistenceFactory getDAOFactory(String arg0) throws Exception {

		// Building concrete factory's name...
		String mClassName = MessageFormat.format("{0}.PersistenceFactory{1}", PersistenceFactory.class.getPackage().getName(), arg0);

		// Building a new concrete factory's instance...
		return (PersistenceFactory) Class.forName(mClassName).getDeclaredConstructor().newInstance();   
	}

	/**
	 * This function returns a {@code PersistenceAddress} object that is used to manage 
	 * {@code Address} object's persistence.
	 * 
	 * @return A {@code PersistenceAddress} object.
	 */
	public abstract PersistenceAddress getPersistenceAddress();

	/**
	 * This function returns a {@code PersistenceCustomer} object that is used to manage 
	 * {@code Customer} object's persistence.
	 * 
	 * @return A {@code PersistenceCustomer} object.
	 */
	public abstract PersistenceCustomer getPersistenceCustomer();
}