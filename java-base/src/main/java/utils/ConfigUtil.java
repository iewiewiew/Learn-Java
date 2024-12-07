package utils;

import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 读取properties
 */
public class ConfigUtil {

    public static void main(String[] args) throws IOException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
    }


    @Test
    public void test1() throws Exception{
        String configPath = new File("").getAbsolutePath() + "\\src\\main\\resources\\test.properties";//获取绝对路径

        Properties pps = new Properties();
        pps.load(new FileInputStream(configPath));
        Enumeration enum1 = pps.propertyNames();//得到配置文件的名字

        while(enum1.hasMoreElements()) {
            String strKey = (String) enum1.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println("key：" + strKey + "， value：" + strValue);
        }
    }
}