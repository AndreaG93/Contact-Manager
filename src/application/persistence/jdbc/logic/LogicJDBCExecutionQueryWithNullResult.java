package application.persistence.jdbc.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogicJDBCExecutionQueryWithNullResult extends LogicJDBC {

    @Override
    public Object extractDataFromResultSet(ResultSet pResultSet) throws SQLException {
        return null;
    }
}
