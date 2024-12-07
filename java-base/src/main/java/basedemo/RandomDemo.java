package basedemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ).format(new Date()));
    }

    @Test
    public void test1(){
        String[] str= new String[]{"01","02","03","04","05","06"};
        Random random = new Random();
        int i = random.nextInt(str.length);
        System.out.println("随机值：" + str[i]);
    }
}
