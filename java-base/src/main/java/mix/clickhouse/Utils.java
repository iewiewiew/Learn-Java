package mix.clickhouse;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Utils {
    Connection connection(ConnEntiy connEntiy);
    void close(AutoCloseable... closes);
    boolean insert(Connection connection, String sql, String... params);
    boolean delete(Connection connection, String sql, String... params);
    ResultSet QueryResultSet(Connection connection, String sql, String... params);
}
