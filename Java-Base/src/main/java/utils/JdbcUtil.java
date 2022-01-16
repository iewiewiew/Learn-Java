package utils;

import java.sql.*;

public class JdbcUtil {

    private static Connection connection;
    private static PreparedStatement ps;
    private static String url;
    private static final String ip = "127.0.0.1";
    private static final int port = 3306;
    private static final String dbname = "dbname";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) throws SQLException {

//        jdbcDemo1();

        String sql = "select * from t_table_info";
        jdbcDemo2(sql);
    }


    /**
     * 一整套：连接+查询+关闭数据库
     */
    public static void jdbcDemo1() {
        String Driver = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://127.0.0.1/dbname?useSSL=false&serverTimezone=GMT";
        String Name = "root";
        String PassWrod = "Smytest01";

        Connection conn = null;
        try {
            //获取驱动
            Class.forName(Driver);
            conn = DriverManager.getConnection(URL, Name, PassWrod);

            Statement stmt = conn.createStatement();  //创建Statement对象
            String sql = "select * from t_table_info";      //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);    //创建数据对象

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("连接数据库失败！");
            e.printStackTrace();
        }
    }


    /**
     * 连接数据库
     */
    public static Connection getConnection() {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://" + ip + ":" + port + "/" + dbname + "?useSSL=false&serverTimezone=GMT";
            return connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 关闭数据库
     * 关闭，释放资源的方法close （若不存在使用下列资源，传递参数为null即可，通过JDBCUtil.close()关闭资源）
     * rs 为结果集，通过JDBC查到的结果集，使用后需关闭释放资源
     * stmt 为开启的sql语句
     * connection 为jdbc的连接
     */
    public static void close(ResultSet rs, Statement stmt, Connection connection) {//栈式关闭（最先连接，最后关闭连接）
        try {//关闭结果集
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {//关闭sql语句
            if (ps != null) ps.close();
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {//关闭连接
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 解耦：连接+查询+关闭数据库
     */
    public static void jdbcDemo2(String sql) {
        Connection connection = JdbcUtil.getConnection();

        try {
            Statement stmt = connection.createStatement();  //创建Statement对象
//            String sql = "select * from t_table_info";
            ResultSet rs = stmt.executeQuery(sql);    //创建数据对象

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, connection);
        }
    }
}
