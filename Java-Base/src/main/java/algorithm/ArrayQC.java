package algorithm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author weimenghua
 * @time 2022-02-23 14:46
 * @description 数组去重
 */
public class ArrayQC {
    public static void main(String[] args) {
        String[] strArr = {"一", "二", "二", "三"};
        test1(strArr);
        test2(strArr);
        test3(strArr);
        test4(strArr);
    }

    //方法1：通过List去重
    public static void test1(String[] arrStr) {
        List<String> list = new ArrayList<>();
        for (String s : arrStr) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        System.out.println(list);

        //返回一个包含所有对象的指定类型的数组
        String[] newArrStr = list.toArray(new String[1]);
        System.out.println(Arrays.toString(newArrStr));
    }

    //方法2：通过Map去重
    public static void test2(String[] arrStr) {
        Map<String, Object> map = new HashMap<>();
        for (String str : arrStr) {
            map.put(str, str);
        }
        System.out.println(map.keySet());
    }

    //方法3：通过Set去重
    public static void test3(String[] arrStr) {
        Set<String> set = new HashSet<>();
        for (String str : arrStr) {
            set.add(str);
        }
        System.out.println(set);
    }

    //方法4：通过lambda去重(jdk1.8)
    public static void test4(String[] arrStr) {
        Stream<String> stream = Arrays.stream(arrStr);
        List<String> list = stream.distinct().collect(Collectors.toList());
        System.out.println(list);
    }
}
