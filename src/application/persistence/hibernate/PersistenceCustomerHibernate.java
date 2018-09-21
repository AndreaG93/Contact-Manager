package application.persistence.hibernate;

import java.util.List;

import application.entity.customer.Customer;
import application.persistence.PersistenceCustomer;
import application.persistence.hibernate.logic.HibernateLogic;

public class PersistenceCustomerHibernate implements PersistenceCustomer {

	@Override
	public int insert(Customer pCustomer) {
		return (int) HibernateLogic.insert(pCustomer);
	}

	@Override
	public void delete(Customer pCustomer) {
		HibernateLogic.delete(pCustomer);

	}

	@Override
	public void update(Customer pCustomer) {
		HibernateLogic.update(pCustomer);	
	}

	@Override
	public Customer get(int pCustomerIdentifier) {

		// Generating query...
		String mQuery = String.format("SELECT * FROM %s WHERE %s = '%s'", 
				Customer.class.getSimpleName(), Customer.COLUMN_ID, pCustomerIdentifier);

		return (Customer) HibernateLogic.getQueryUniqueResult(mQuery);
	}

	@Override
	public List<Customer> getPageableCollection(int pageSize, int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}