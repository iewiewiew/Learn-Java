package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SqlToTxt {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        jdbcDemo1();
    }

    public static void jdbcDemo1() {
        String Driver = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://127.0.0.1/dbname?useSSL=false&serverTimezone=GMT";
        String Name = "root";
        String PassWrod = "root";

        Connection conn = null;
        try {
            //获取驱动
            Class.forName(Driver);
            conn = DriverManager.getConnection(URL, Name, PassWrod);

            Statement stmt = conn.createStatement();  //创建Statement对象
            String sql = "select * from dbname.t_table_info";      //要执行的SQL
            ResultSet rs = stmt.executeQuery(sql);    //创建数据对象
            String txtFilePath = GetPath.getFilePath() + "\\files\\sqldemo.txt";
            System.out.println("txt文件路径： " + txtFilePath);

            File file = new File(txtFilePath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
                bw.write(rs.getString(2));
                bw.newLine(); //换行
            }
            bw.close();
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("连接数据库失败！");
            e.printStackTrace();
        }
    }
}
