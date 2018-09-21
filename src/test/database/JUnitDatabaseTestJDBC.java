package test.database;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import application.persistence.PersistenceCustomer;
import application.persistence.factory.PersistenceFactory;

/**
 * This class provides some method to test database using 'Hibernate'.
 *
 * @version 1.0
 * @author Andrea Graziani
 */
class JUnitDatabaseTestJDBC extends JUnitDatabaseTest {

    @Test
    public void JDBCTest() {
 
		try {
			
			// Get 'JDBC' DAO factory...
	        // =================================================================== //
	        PersistenceFactory myDaoFactory = null;
			myDaoFactory = PersistenceFactory.getDAOFactory(PersistenceFactory.JDBC);		
			
			// Getting needed DAO classes...
	        // =================================================================== //
			assertNotNull(myDaoFactory);
			PersistenceCustomer myCustomerDAO = myDaoFactory.getPersistenceCustomer();
	        assertNotNull(myCustomerDAO);

	        // Start test...
	        customerCRUDTest(myCustomerDAO);
						
		} catch (Exception e) {		
			fail();
		}  
    }
}