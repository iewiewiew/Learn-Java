package basedemo;



import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Test
    public void test1() {
        try {
            String[] str = {"张三", "李四", "王五"};
            System.out.println(str[5]);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常信息：" + e);
        }
    }


    @Test
    public void test2(){
        try {
            String[] str = {"张三", "李四", "王五"};
            System.out.println(str[5]);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常信息：" + e);
        }finally {
            System.out.printf("finally：无论遇到什么异常一定会执行的");
        }
    }
}
