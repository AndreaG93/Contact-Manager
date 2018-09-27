package application.persistence.jdbc;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import application.entity.customer.Customer;
import application.persistence.jdbc.annotation.CustomerSetterJDBC;
import application.entity.customer.Gender;
import application.entity.customer.Title;
import application.persistence.PersistenceCustomer;
import application.persistence.jdbc.logic.LogicJDBC;
import application.persistence.jdbc.logic.LogicJDBCExecutionQueryUniqueIntegerResult;
import application.persistence.jdbc.logic.LogicJDBCExecutionQueryUniqueLongResult;
import application.persistence.jdbc.logic.LogicJDBCExecutionQueryWithNullResult;

public class PersistenceCustomerJDBC implements PersistenceCustomer {

    private final List<Method> customerSetterJDBCMethodList;

    public PersistenceCustomerJDBC() {

        this.customerSetterJDBCMethodList = new ArrayList<>();

        for (Method mMethod : Arrays.asList((Customer.class.getDeclaredMethods())))
            if(mMethod.isAnnotationPresent(CustomerSetterJDBC.class))
                customerSetterJDBCMethodList.add(mMethod);
    }



    @Override
    public int insert(Customer pCustomer) {

        // Allocation 'LogicJDBC' object...
        LogicJDBC mLogicJDBC = new LogicJDBCExecutionQueryUniqueIntegerResult();

        // Generating query...
        String mQuery = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES ('%s','%s','%s','%s') RETURNING %s",
                Customer.class.getSimpleName(),
                Customer.COLUMN_NAME, Customer.COLUMN_SURNAME, Customer.COLUMN_TITLE, Customer.COLUMN_GENDER,
                pCustomer.getName(),
                pCustomer.getSurname(),
                pCustomer.getTitle().ordinal(),
                pCustomer.getGender().ordinal(),
                Customer.COLUMN_ID);

        // Perform...
        return (int) mLogicJDBC.performQuery(mQuery);
    }

    @Override
    public void delete(Customer pCustomer) {

        // Allocation 'LogicJDBC' object...
        LogicJDBC mLogicJDBC = new LogicJDBCExecutionQueryWithNullResult();

        // Generating query...
        String mQuery = String.format("DELETE FROM %s CASCADE WHERE %s='%s' RETURNING NULL",
                Customer.class.getSimpleName(),
                Customer.COLUMN_ID, pCustomer.getID());

        // Perform...
        mLogicJDBC.performQuery(mQuery);
    }

    @Override
    public void update(Customer pCustomer) {

        // Allocation 'LogicJDBC' object...
        LogicJDBC mLogicJDBC = new LogicJDBCExecutionQueryWithNullResult();

        // Generating query...
        String mQuery = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='%s' WHERE %s='%s' RETURNING NULL",
                Customer.class.getSimpleName(),
                Customer.COLUMN_NAME, pCustomer.getName(),
                Customer.COLUMN_SURNAME, pCustomer.getSurname(),
                Customer.COLUMN_TITLE, pCustomer.getTitle().ordinal(),
                Customer.COLUMN_GENDER, pCustomer.getGender().ordinal(),
                Customer.COLUMN_ID, pCustomer.getID());

        // Perform...
        mLogicJDBC.performQuery(mQuery);
    }

    @Override
    public Customer get(int id) {

        // Allocation 'LogicJDBC' object...
        LogicJDBC mLogicJDBC = new LogicJDBC() {

            public Object extractDataFromResultSet(ResultSet pResultSet) throws SQLException {

                Customer output = null;

                if (pResultSet.next()) {

                    output = new Customer();

                    for (Method method : customerSetterJDBCMethodList) {

                        try{
                            // Retrieve column name...
                            String columnName = method.getAnnotation(CustomerSetterJDBC.class).columnName();
                            // Retrieve and set data...
                            method.invoke(output, pResultSet.getObject(columnName));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                return output;
            }
        };

        // Generating query...
        String mQuery = String.format("SELECT * FROM %s WHERE %s = '%s'",
                Customer.class.getSimpleName(), Customer.COLUMN_ID, id);

        // Perform...
        return (Customer) mLogicJDBC.performQuery(mQuery);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Customer> getPageableCollection(int pageSize, int pageNumber) {

        // Allocation 'LogicJDBC' object...
        LogicJDBC mLogicJDBC = new LogicJDBC() {

            public Object extractDataFromResultSet(ResultSet pResultSet) throws SQLException {

                ArrayList<Customer> mOutput = new ArrayList<>();

                while (pResultSet.next()) {
                    Customer mCustomer = new Customer();

                    mCustomer.setID(pResultSet.getInt(Customer.COLUMN_ID));
                    mCustomer.setName(pResultSet.getString(Customer.COLUMN_NAME));
                    mCustomer.setSurname(pResultSet.getString(Customer.COLUMN_SURNAME));
                    mCustomer.setTitle(Title.values()[(pResultSet.getInt(Customer.COLUMN_TITLE))]);
                    mCustomer.setGender(Gender.values()[(pResultSet.getInt(Customer.COLUMN_GENDER))]);

                    mOutput.add(mCustomer);
                }

                return mOutput;
            }
        };

        // Generating query...
        String mQuery = String.format("SELECT * FROM %s LIMIT %s OFFSET %s",
                Customer.class.getSimpleName(), pageSize, pageNumber);

        // Perform...
        return (List<Customer>) mLogicJDBC.performQuery(mQuery);
    }

    @Override
    public long getCount() {

        // Allocation 'LogicJDBC' object...
        LogicJDBC mLogicJDBC = new LogicJDBCExecutionQueryUniqueLongResult();

        // Generating query...
        String mQuery = String.format("SELECT COUNT(*) FROM %s", Customer.class.getSimpleName());

        // Perform...
        return (long) mLogicJDBC.performQuery(mQuery);
    }
}