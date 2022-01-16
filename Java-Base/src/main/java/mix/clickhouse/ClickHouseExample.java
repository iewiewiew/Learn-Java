package mix.clickhouse;

import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClickHouseExample {
    public static void main(String[] args) {
        ClickHouseProperties properties = new ClickHouseProperties();
        properties.setUser("default");
        properties.setPassword("123456");

        ClickHouseDataSource dataSource = new ClickHouseDataSource("jdbc:clickhouse://114.67.240.27:8123/tutorial", properties);

        try(Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {

            // 查询数据
            ResultSet resultSet = statement.executeQuery("SELECT MobilePhone, Title FROM hits_v1 limit 5");
            // ResultSet resultSet = statement.executeQuery("desc hits_v1");
            while (resultSet.next()) {
                // 处理查询结果
                // System.out.println("resultSet: " + resultSet);
                System.out.println("MobilePhone: " + resultSet.getInt("MobilePhone") + ", Title: " + resultSet.getString("Title"));
            }

            // 插入数据
            // int rowsInserted = statement.executeUpdate("INSERT INTO your_table (name_column, name_column, name_column");
            // System.out.println("Rows inserted: " + rowsInserted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
