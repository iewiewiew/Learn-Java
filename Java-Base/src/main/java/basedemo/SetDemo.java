package basedemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class SetDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Test
    public void test1() {
        HashSet hashSet = new HashSet();
        hashSet.add("我");
        hashSet.add("要");
        hashSet.add("发");
        hashSet.add("财");
        hashSet.add("财");
        hashSet.add("财");
        System.out.println("HashSet去重：" + hashSet);
    }
}
