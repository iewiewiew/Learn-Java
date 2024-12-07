package basedemo;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }


    /**
     * HashMap<Integer,String>：put
     */
    @Test
    public void test1() {
        //创建HashMap对象demo
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        //键值对
        hashMap.put(1, "张三");
        hashMap.put(2, "李四");
        hashMap.put(3, "王五");
        System.out.println("数组：" + hashMap);
        System.out.println("key=1的值：" + hashMap.get(1));
        System.out.println("数组长度：" + hashMap.size());
    }


    @Test
    public void test2() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("姓名1", "张三");
        map.put("姓名2", "李四");
        map.put("姓名3", "王五");

        System.out.printf(JSON.toJSONString(map));
    }


    @Test
    public void test3() {
        Map<String, Map<String, Integer>> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map2.put("张三", 18);
        map2.put("李四", 19);
        map2.put("王五", 20);
        map1.put("map1", map2);

        System.out.printf(JSON.toJSONString(map1));
    }


    @Test
    public void test4() {
        List<Map<String, Map<String, Integer>>> list = new ArrayList<>();
        Map<String, Map<String, Integer>> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        map2.put("张三", 18);
        map2.put("李四", 19);
        map2.put("王五", 20);

        map1.put("map1", map2);

        list.add(map1);

        System.out.printf(JSON.toJSONString(list));
    }
}