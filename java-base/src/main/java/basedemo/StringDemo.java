package basedemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weimenghua
 * @date 2021-11-17 22:58
 */
public class StringDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Test
    public void test1() {
        String s1, s2;
        s1 = "we are students";
        s2 = "we are students";
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

        String s3, s4;
        s3 = "how are you";
        s4 = "how are you";
        System.out.println(s3.equals(s4));
        System.out.println(s3 == s4);
    }


    /**
     * 当对字符串进行修改的时候，需要使用StringBuffer和 StringBuilder类
     * 和 String 类不同的是，StringBuffer和StringBuilder的对象能够被多次的修改，并且不产生新的未使用对象
     * 由于StringBuilder相较于StringBuffer有速度优势，所以多数情况下建议使用 StringBuilder 类。
     */
    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder();
        sb.append("我");
        sb.append("要");
        sb.append("发");
        sb.append("财");
        System.out.println("StringBuilder：" + sb);
    }


    @Test
    public void test3() {
        StringBuffer sb = new StringBuffer();
        sb.append("我");
        sb.append("要");
        sb.append("发");
        sb.append("财");
        System.out.println("StringBuffer：" + sb);
    }
}
