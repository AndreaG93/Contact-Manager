package test.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import application.entity.address.Address;
import application.entity.customer.Customer;
import application.entity.customer.Gender;
import application.entity.customer.Title;
import application.persistence.PersistenceAddress;
import application.persistence.PersistenceCustomer;

/**
 * This class provides some method to test database.
 *
 * @version 1.0
 * @author Andrea Graziani
 */
class JUnitDatabaseTest {

    // 'Address' data
    // =================================================================== //

    // Before 'UPDATE'...
    private static final String ADDRESS_1 = "Via Arcturus";
    private static final String TOWN_1 = "Luna Nova";
    private static final String PROVINCE_1 = "Arcturus";
    private static final String POSTCODE_1 = "00088";
    // After 'UPDATE'...
    private static final String ADDRESS_2 = "Via You";
    private static final String TOWN_2 = "ChikaTown";
    private static final String PROVINCE_2 = "Roma";
    private static final String POSTCODE_2 = "00077";

    // 'Customer' data
    // =================================================================== //

    // Before 'UPDATE'...
    private static final String NAME_1 = "Atsuko";
    private static final String SURNAME_1 = "Kagari";
    private static final Title TITLE_1 = Title.Adv;
    private static final Gender GENDER_1 = Gender.Male;
    // After 'UPDATE'...
    private static final String NAME_2 = "Diana";
    private static final String SURNAME_2 = "Cavendish";
    private static final Title TITLE_2 = Title.Miss;
    private static final Gender GENDER_2 = Gender.Female;

    /**
     * This method is used to test specified {@code AddressDAO} object performing all CRUD operations.
     *
     * @param pAddressDAO - Represents an {@code AddressDAO} object.
     */
    protected static void addressCRUDTest(PersistenceAddress pAddressDAO) {

        // Sub-test 1: Create / INSERT...
        // =================================================================== //
        Address mObj = new Address();
        mObj.setAddress(ADDRESS_1);
        mObj.setTown(TOWN_1);
        mObj.setProvince(PROVINCE_1);
        mObj.setPostcode(POSTCODE_1);

        // Inserting...
        int mID = pAddressDAO.insert(mObj);

        // Sub-test 2: Read / SELECT...
        // =================================================================== //
        Address mAddress = pAddressDAO.get(mID);

        assertNotNull(mAddress);
        assertEquals(mID, mAddress.getId());

        assertEquals(ADDRESS_1, mAddress.getAddress());
        assertEquals(TOWN_1, mAddress.getTown());
        assertEquals(PROVINCE_1, mAddress.getProvince());
        assertEquals(POSTCODE_1, mAddress.getPostcode());

        // Sub-test 3: Update / UPDATE...
        // =================================================================== //
        mAddress.setAddress(ADDRESS_2);
        mAddress.setTown(TOWN_2);
        mAddress.setProvince(PROVINCE_2);
        mAddress.setPostcode(POSTCODE_2);

        // Updating...
        pAddressDAO.update(mAddress);
        // Retrieving...
        mAddress = pAddressDAO.get(mID);

        assertEquals(ADDRESS_2, mAddress.getAddress());
        assertEquals(TOWN_2, mAddress.getTown());
        assertEquals(PROVINCE_2, mAddress.getProvince());
        assertEquals(POSTCODE_2, mAddress.getPostcode());

        // Sub-test 4: Delete / DELETE...
        // =================================================================== //
        pAddressDAO.delete(mAddress);
        assertNull(pAddressDAO.get(mID));
    }

    /**
     * This method is used to test specified {@code CustomerDAO} object performing all CRUD operations.
     *
     * @param pCustomerDAO - Represents an {@code CustomerDAO} object.
     */
    protected static void customerCRUDTest(PersistenceCustomer pCustomerDAO) {

        // Sub-test 1: Create / INSERT...
        // =================================================================== //
        Customer mObj = new Customer();
        mObj.setName(NAME_1);
        mObj.setSurname(SURNAME_1);
        mObj.setTitle(TITLE_1);
        mObj.setGender(GENDER_1);

        // Inserting...
        int mID = pCustomerDAO.insert(mObj);

        // Sub-test 2: Read / SELECT...
        // =================================================================== //
        Customer mCustomer = pCustomerDAO.get(mID);

        assertNotNull(mCustomer);
        assertEquals(mID, mCustomer.getID());

        assertEquals(NAME_1, mCustomer.getName());
        assertEquals(SURNAME_1, mCustomer.getSurname());
        assertEquals(TITLE_1, mCustomer.getTitle());
        assertEquals(GENDER_1, mCustomer.getGender());

        // Sub-test 3: Update / UPDATE...
        // =================================================================== //
        mCustomer.setName(NAME_2);
        mCustomer.setSurname(SURNAME_2);
        mCustomer.setTitle(TITLE_2);
        mCustomer.setGender(GENDER_2);

        // Updating...
        pCustomerDAO.update(mCustomer);
        // Retrieving...
        mCustomer = pCustomerDAO.get(mID);

        assertEquals(NAME_2, mCustomer.getName());
        assertEquals(SURNAME_2, mCustomer.getSurname());
        assertEquals(TITLE_2, mCustomer.getTitle());
        assertEquals(GENDER_2, mCustomer.getGender());

        // Sub-test 4: Delete / DELETE...
        // =================================================================== //
        pCustomerDAO.delete(mCustomer);
        assertNull(pCustomerDAO.get(mID));
    }
}
