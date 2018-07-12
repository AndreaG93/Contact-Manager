package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import controllers.dao.AddressDAO;
import controllers.dao.CustomerDAO;
import controllers.dao.factory.DAOFactory;
import entity.address.Address;
import entity.customer.Customer;
import entity.customer.Gender;
import entity.customer.Title;



public class HibernateDAOTest {

    // Data for Address object...
    static final String address = "Via Arcturus";
    static final String town = "Luna Nova";
    static final String province = "Arcturus";
    static final String postcode = "00088";

    // Data for Customer object...
    static final String name = "Atsuko";
    static final String name2 = "Diana";
    static final String surname = "Kagari";
    static final Title title = Title.Miss;
    static final Gender gender = Gender.Female;


    @Test
    public void Address() {
        // Get 'Hibernate' DAO factory...
        DAOFactory myDaoFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);
        assertNotNull(myDaoFactory);

        // Get DAO class...
        AddressDAO myAddressDAO = myDaoFactory.getAddressDAO();
        assertNotNull(myAddressDAO);

        // Creation object...
        /* *************************************************************** */
        Address myAddressObj = new Address();
        myAddressObj.setAddress(address);
        myAddressObj.setProvince(town);
        myAddressObj.setPostcode(province);
        myAddressObj.setTown(postcode);

        /* Test CRUD operation... */
        /* *************************************************************** */

        //myAddressDAO.insertAddress(myAddressObj);

        // Insert...
        int id = myAddressDAO.insert(myAddressObj);

        // Get...
        assertEquals(id, myAddressDAO.get(id).getId());

        // Update...
        myAddressObj.setProvince("Tokyo");
        myAddressDAO.update(myAddressObj);
        assertEquals("Tokyo", myAddressDAO.get(id).getProvince());

        // Delete...
        myAddressDAO.delete(myAddressObj);
        assertEquals(null, myAddressDAO.get(id));
    }


    @Test
    public void Customer() {
        // Get 'Hibernate' DAO factory...
        DAOFactory myDaoFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);
        assertNotNull(myDaoFactory);

        // Get DAO class...
        CustomerDAO myCustomerDAO = myDaoFactory.getCustomerDAO();
        assertNotNull(myCustomerDAO);

        // Get DAO class...
        AddressDAO myAddressDAO = myDaoFactory.getAddressDAO();
        assertNotNull(myAddressDAO);

        // Creation object...
        /* *************************************************************** */
        Address myAddressObj = new Address();
        myAddressObj.setAddress(address);
        myAddressObj.setProvince(town);
        myAddressObj.setPostcode(province);
        myAddressObj.setTown(postcode);

        Customer myCustomer = new Customer();
        myCustomer.setName(name);
        myCustomer.setSurname(surname);
        myCustomer.setTitle(title);
        myCustomer.setGender(gender);
        myCustomer.setAddress(myAddressObj);

        /* Test CRUD operation... */
        /* *************************************************************** */


        // Insert...
        int id = myCustomerDAO.insert(myCustomer);

        // Get...
        assertEquals(id, myCustomerDAO.get(id).getId());
        assertEquals(gender, myCustomerDAO.get(id).getGender());

        // Update...
        myCustomer.setName(name2);
        myCustomerDAO.update(myCustomer);
        assertEquals(name2, myCustomerDAO.get(id).getName());

        // Delete...
        myCustomerDAO.delete(myCustomer);
        assertEquals(null, myCustomerDAO.get(id));
    }

}
