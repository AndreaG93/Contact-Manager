package controllers.dao.hibernate;

import entity.customer.Customer;
import java.text.MessageFormat;
import java.util.List;
import controllers.dao.CustomerDAO;
import controllers.dao.factory.HibernateDAOFactory;

/**
 * 
 * @author andrea
 *
 */
public class HibernateCustomerDAO implements CustomerDAO {

	@Override
	public int insert(Customer obj) {
		return (int) HibernateDAOFactory.save(obj);
	}

	@Override
	public void delete(Customer obj) {
		HibernateDAOFactory.delete(obj);
	}

	@Override
	public void update(Customer obj) {
		HibernateDAOFactory.update(obj);
	}

	@Override
	public Customer get(int id) {

		// Generate query...
		String query = MessageFormat.format("FROM Customer WHERE customer_id = {0}", id);

		// Perform query and return requested object...
		return (Customer) HibernateDAOFactory.performQueryUniqueResult(query);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getPageableCollections(int pageSize, int pageNumber) {
		return (List<Customer>) HibernateDAOFactory.performQueryPageableCollections("FROM Customer", pageSize, pageNumber);
	}

	@Override
	public long getCount() {
		
		return (long) HibernateDAOFactory.performQueryUniqueResult("SELECT count(*) FROM Customer");
	}
}
