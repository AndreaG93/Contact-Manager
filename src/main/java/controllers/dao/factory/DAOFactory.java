package controllers.dao.factory;

import java.text.MessageFormat;

import controllers.dao.AddressDAO;
import controllers.dao.CustomerDAO;

public abstract class DAOFactory {

    public static final String HIBERNATE = "Hibernate";

    /**
     * This function is used to get a concrete DAO factory.
     *
     * @param arg0 Name of requested factory type.
     * @return A {@code DAOFactory} object.
     */
    public static DAOFactory getDAOFactory(String arg0) {

        // Building concrete factory's name...
        String nameDAOFactory = MessageFormat.format("{0}.{1}DAOFactory", DAOFactory.class.getPackage().getName(), arg0);

        // Building a new concrete factory's instance...
        try {
            return (DAOFactory) Class.forName(nameDAOFactory).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    public abstract AddressDAO getAddressDAO();

    public abstract CustomerDAO getCustomerDAO();
}
