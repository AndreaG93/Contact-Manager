package application.persistence.jdbc.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogicJDBCExecutionQueryUniqueLongResult extends LogicJDBC {

    @Override
    public Object extractDataFromResultSet(ResultSet pResultSet) throws SQLException {

        pResultSet.next();
        return pResultSet.getLong(1);
    }
}