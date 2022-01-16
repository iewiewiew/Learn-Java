package basedemo;



import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * @author weimenghua
 * @date 2021-11-20 11:08
 */
public class IteratorDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Test
    public void test1() {
        //创建集合
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("张三");
        sites.add("李四");
        sites.add("王五");

        //获取迭代器
        Iterator<String> it = sites.iterator();
        System.out.println("检测集合中是否还有元素：" + it.hasNext());
        while (it.hasNext()) {
            String str = it.next();
            if ("张三".equals(str)) {
                it.remove();
            } else {
                System.out.println("返回迭代器的下一个元素，并且更新迭代器的状态? " + it.next());
            }
        }
    }
}