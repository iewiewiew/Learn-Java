package basedemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class Java8ThreadDemo {

    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * lambda 表达式创建线程
     */
    @Test
    public void test1(){
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println( "创建线程:" + i);
            }
        });
        t.start();
    }

    /**
     * 遍历集合
     */
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1,2,3,4,5);
        //lambda表达式 方法引用
        System.out.printf("System.out::println循环输出：\n");
        list.forEach(System.out::println);

        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println("element：" + element);
            }
        });
    }
}