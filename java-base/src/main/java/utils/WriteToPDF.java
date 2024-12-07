package utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/*Linux执行jar包：
/usr/java/jdk1.8.0_271/bin/java  -Dparam=name_demo -cp /tmp/Learn-Java.jar utils.WriteToPDF;
*/

public class WriteToPDF {

    public static void main(String[] args) throws Exception {
        String outPath = GetPath.getFilePath() + "/files/";
        if (runningOnWindows() == true){
            String name = "律师";
            DataWriteToPDF(outPath,name);
        }else{
            String name = System.getProperty("param");
            DataWriteToPDF(outPath,name);
        }
    }

    //Linux环境下生成PDF文件路径
    public static String PDFPATH = "/tmp/";

    
    //判断当前环境是Windows还是Linux
    private static boolean runningOnWindows(){
        String system = System.getProperty("os.name");
        return system.indexOf("Windows") >= 0;
    }

    //判断目录是否存在，如果不存在则创建
    private static void isChartPathExist(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    //创建一个最基本的pdf
    public static void fillTemplate(String outpath, String id, String name) throws IOException, DocumentException {

        String filePath = outpath + id + "_" + name + ".pdf";

        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 18, Font.NORMAL);

        try {
            //1 创建Document
            Document document = new Document();
            //2 获取PdfWriter
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            //3 打开
            document.open();
            //4 添加内容
            document.add(new Paragraph("文件名称：" + id + "_" + name + "_" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()), fontChinese));
            //5 关闭
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //连接数据库
    public static Connection getConnection() {
        String Driver = "com.mysql.cj.jdbc.Driver";
        String URL = "jdbc:mysql://127.0.0.1/dbname?useSSL=false&serverTimezone=GMT";
        String Name = "root";
        String PassWrod = "123456";
        Connection connection;

        try {
            //获取驱动
            Class.forName(Driver);
            return connection = DriverManager.getConnection(URL, Name, PassWrod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取数据库的值生成PDF
    public static void DataWriteToPDF(String outPath, String name){
        Connection conn = WriteToPDF.getConnection();

        try {

            Statement stmt = conn.createStatement();
            String sql = "select * from t_table_info limit 3";

            PreparedStatement prepStmt = conn.prepareStatement(sql);
//            prepStmt.setString(1, name);  //传参用
            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                WriteToPDF wp = new WriteToPDF();

                if (runningOnWindows() == true){
                    fillTemplate(outPath, rs.getString(1), name);
                    System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
                }else{
                    switch(name){
                        case "name_demo" :
                            String str = rs.getString(0) + "_" + rs.getString(1);
                            isChartPathExist(outPath);
                            fillTemplate(outPath, rs.getString(1), name);
                            break;
                        default :
                            System.out.println("请输入正确参数！");
                    }
                }
                System.out.println("字段：" + name);

            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}