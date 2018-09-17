package controllers.dao.hibernate;

import entity.address.Address;
import java.text.MessageFormat;
import controllers.dao.AddressDAO;
import controllers.dao.factory.HibernateDAOFactory;

public class HibernateAddressDAO implements AddressDAO {

	@Override
	public int insert(Address obj) {
		return (int) HibernateDAOFactory.save(obj);
	}

	@Override
	public void delete(Address obj) {
		HibernateDAOFactory.delete(obj);
	}

	@Override
	public void update(Address obj) {
		HibernateDAOFactory.update(obj);
	}

	@Override
	public Address get(int id) {

		// Generate query...
		String query = MessageFormat.format("FROM Address WHERE address_id = {0}", id);

		// Perform query and return requested object...
		return (Address) HibernateDAOFactory.performQueryUniqueResult(query);
	}
}
