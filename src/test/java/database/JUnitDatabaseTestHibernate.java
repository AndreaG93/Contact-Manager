package database;

import controllers.dao.AddressDAO;
import controllers.dao.CustomerDAO;
import controllers.dao.factory.DAOFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class provides some method to test database using 'Hibernate'.
 *
 * @version 1.0
 * @author Andrea Graziani
 */
class JUnitDatabaseTestHibernate extends JUnitDatabaseTest {

    @Test
    public void addressHibernateTest() {

        // Get 'Hibernate' DAO factory...
        // =================================================================== //
        DAOFactory myDaoFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);
        assertNotNull(myDaoFactory);

        // Get DAO class...
        // =================================================================== //
        AddressDAO myAddressDAO = myDaoFactory.getAddressDAO();
        assertNotNull(myAddressDAO);

        // Start test...
        addressCRUDTest(myAddressDAO);
    }

    @Test
    public void customerHibernateTest() {

        // Get 'Hibernate' DAO factory...
        // =================================================================== //
        DAOFactory myDaoFactory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);
        assertNotNull(myDaoFactory);

        // Get DAO class...
        // =================================================================== //
        CustomerDAO myCustomerDAO = myDaoFactory.getCustomerDAO();
        assertNotNull(myCustomerDAO);

        // Start test...
        customerCRUDTest(myCustomerDAO);
    }
}
