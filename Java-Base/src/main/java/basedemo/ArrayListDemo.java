package basedemo;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * 教程：https://www.runoob.com/java/java-arraylist.html
 * ArrayList<E> objectName =new ArrayList<>();　 // 初始化
 * E: 泛型数据类型，用于设置 objectName 的数据类型，只能为引用数据类型。
 * objectName: 对象名。
 * ArrayList 是一个数组队列，提供了相关的添加、删除、修改、遍历等功能。
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }


    /**
     * ArrayList<String>：add、set、remove、get、size
     */
    @Test
    public void test1() {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("张三");
        sites.add("李四");
        sites.add("王五");
        sites.set(2, "修改后的王五"); //第1个参数为索引位置，第2个为要修改的值
        sites.remove(1); //删除索引为2的值

        System.out.println("数组：" + sites);
        System.out.println("第2个元素：" + sites.get(1));
        System.out.printf("查看数组大小：" + sites.size() + "\n");
        for (int i = 0; i < sites.size(); i++) {
            System.out.println("第" + i + "个元素：" + sites.get(i));
        }
        for (String i : sites) {
            System.out.println("第*个元素：" + i);
        }
    }


    /**
     * ArrayList<Integer>：add
     * ArrayList 中的元素实际上是对象，在以上实例中，数组列表元素都是字符串 String 类型。
     * 如果我们要存储其他类型，而 <E> 只能为引用数据类型，这时我们就需要使用到基本类型的包装类。
     */
    @Test
    public void test2() {
        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(1);
        num.add(2);
        num.add(3);
        for (int i : num) {
            System.out.println("第*个元素：" + i);
        }
    }


    /**
     * ArrayList<String>：Collections.sort()排序
     */
    @Test
    public void test3() {
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("张三");
        sites.add("李四");
        sites.add("王五");

        Collections.sort(sites); //排序
        for (String i : sites) {
            System.out.println("排序后的第*个元素：" + i);
        }
    }
}