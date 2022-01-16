package basedemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
    }

    @Test
    public void test1(){
        System.out.println("请输入：");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()){
            String str = scan.next();
            System.out.println("从键盘获取的数据为:" + str);
        }
        scan.close();
    }
}
