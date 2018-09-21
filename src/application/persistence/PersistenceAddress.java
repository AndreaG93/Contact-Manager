package application.persistence;

import application.entity.address.Address;

/**
 * This class provides an interface to manage {@code Address} object persistence.
 * 
 * @author Andrea Graziani
 * @version 1.0
 */
public interface PersistenceAddress {

	/**
	 * This method is used to insert a {@code Address} object into persistence system.
	 * 
	 * @param pAddress - Represents a {@code Address} object.
	 * @return An {@code int} value.
	 */
	public int insert(Address pAddress);

	/**
	 * This method is used to delete a {@code Customer} object from persistence system.
	 * 
	 * @param pAddress - Represents a {@code Customer} object.
	 */
	public void delete(Address pAddress);

	/**
	 * This method is used to update a {@code Customer} object already saved in persistence system.
	 * 
	 * @param pAddress - Represents a {@code Customer} object.
	 */
	public void update(Address pAddress);

	/**
	 * This method is used to get a {@code Address} object stored in persistence system.
	 * 
	 * @param pAddressIdentifier - Represents an {@code int} value.
	 */
	public Address get(int pAddressIdentifier);
}