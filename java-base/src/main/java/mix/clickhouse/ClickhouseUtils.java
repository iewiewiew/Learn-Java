package mix.clickhouse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ClickhouseUtils implements Utils {

    @Override
    public Connection connection(ConnEntiy connEntiy) {
        // 声明并初始化一个 Connection 类型的变量 conn，初始值为 null。这个变量将用于存储数据库连接。
        Connection conn = null;
        try {
            // 通过反射加载 JDBC 驱动。connEntiy.getDriverName() 返回驱动的类名，例如 "ru.yandex.clickhouse.ClickHouseDriver"。这一步确保 JDBC 驱动在使用之前被正确加载。
            Class.forName(connEntiy.getDriverName());
            // 如果连接成功，conn 将被赋值为有效的 Connection 对象。
            conn = DriverManager.getConnection(connEntiy.getUrl(), connEntiy.getUser(), connEntiy.getPassword());    
        } catch (Exception e) {
            System.out.println("Connection failed:" + e.getMessage());
        }
        return conn;
    }

    @Override
    public void close(AutoCloseable... closes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }

    @Override
    public boolean insert(Connection connection, String sql, String... params) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public boolean delete(Connection connection, String sql, String... params) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ResultSet QueryResultSet(Connection connection, String sql, String... params) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'QueryResultSet'");
    }
    
}
