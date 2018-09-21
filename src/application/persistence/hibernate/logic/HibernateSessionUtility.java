package application.persistence.hibernate.logic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * This class provides some method to deal with 'Hibernate' sessions.
 * 
 * @author Andrea
 * @version 1.0
 */
public class HibernateSessionUtility {

	private final SessionFactory factory; 

	 /**
     * Following class is used according to 'initialization-on-demand holder' pattern.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom">Initialization-on-demand holder idiom</a>
     */
    private static class HibernateSessionLazyHolder {
        static final HibernateSessionUtility INSTANCE = new HibernateSessionUtility();
    }
    
    /**
     * This method is used to retrieve a {@code HibernateSessionUtility} object instance.
     * 
     * @return A {@code HibernateSessionUtility} object
     */
    private static HibernateSessionUtility getInstance() { 
		return HibernateSessionLazyHolder.INSTANCE; 
	}

    /**
     * Constructs a newly allocated {@code HibernateSessionUtility} object.
     */
	private HibernateSessionUtility() { 
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); 
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory(); 
	} 

	/**
	 * This method is used to retrieve a {@code Session} object instance.
	 * 
	 * @return  A {@code HibernateSessionUtility} object
	 */
	public static Session getSession() { 
		return getInstance().factory.openSession(); 
	} 
}