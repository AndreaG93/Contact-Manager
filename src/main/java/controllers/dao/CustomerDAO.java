package controllers.dao;

import java.util.List;
import entity.customer.Customer;

public interface CustomerDAO {

	public int insert(Customer arg);

	public void delete(Customer arg);

	public void update(Customer arg);

	public Customer get(int id);

	public List<Customer> getPageableCollections(int pageSize, int pageNumber);

	public long getCount();
}
