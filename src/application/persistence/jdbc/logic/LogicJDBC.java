package application.persistence.jdbc.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class contains application logic to manage a JDBC based persistence system.
 * 
 * @author Andrea Graziani
 * @version 1.0
 */
public abstract class LogicJDBC {

	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final String DB_URL = "jdbc:postgresql://localhost:5432/HibernateDB";
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "andrea";
	
	/**
	 * This function is used to extract data from specified {@code ResultSet} object.
	 * 
	 * @param pResultSet - Represents a {@code ResultSet} object.
	 * @return An {@code Object}.
	 * @throws SQLException
	 */
	public abstract Object extractDataFromResultSet(ResultSet pResultSet) throws SQLException; 
		
	/**
	 * This function is used to perform a specified query.
	 * 
	 * @param pQuery - Represents a {@code String} object.
	 * @return An {@code Object}.
	 */
	public Object performQuery(String pQuery)  {

		Object output = null;
		Connection mConnection = null;
		Statement mStatement = null;

		try{

			// Register JDBC driver...
			Class.forName(JDBC_DRIVER);

			// Open a connection...
			mConnection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

			// Execute specified query...
			mStatement = mConnection.createStatement();
			ResultSet mResultSet = mStatement.executeQuery(pQuery);

			// Extract data from given 'ResultSet' object ...
			output = extractDataFromResultSet(mResultSet);
	
			// Close used resources...
			mResultSet.close();
			mStatement.close();
			mConnection.close();

		} catch(Exception e) {

			e.printStackTrace();
			System.exit(1);

		} finally {

			// Closing 'Statement' object...
			if (mStatement!=null)
				try {
					mStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.exit(1);
				}
			
			// Closing 'Connection' object...
			if (mConnection!=null)
				try {
					mConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.exit(1);
				}
			
			
		}

		return output;
	}
}