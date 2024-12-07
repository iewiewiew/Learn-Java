package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 查找数组出现最多次数的数字
 */
public class FindMostInArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        System.out.println("方法一:" + findMostInArray(a));
        System.out.println("方法二:" + findMostInArray2(a));
    }

    /**
     * 方法一：空间换时间。
     * 可以定义一个计数数组int count[101]，
     * 用来对数组中数字出现的次数进行计数（只能针对数组中数字的范围1~100），
     * count数组中最大的元素对应的下标，即为出现次数最多的那个数
     */
    public static int findMostInArray(int[] a) {
        int[] count = new int[101];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }
        int maxCount = count[0];
        int maxNumber = a[0];
        for (int i = 0; i < 100; i++) {
            maxCount = count[i] > maxCount ? count[i] : maxCount;
        }
        for (int i = 0; i < 100; i++) {
            if (count[i] == maxCount) {
                maxNumber = i;
            }
        }
        return maxNumber;
    }

    /**
     * 方法二：使用Map映射表
     */
    public static int findMostInArray2(int[] a) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }
        //找出出现次数最多的元素
        int most = 0;
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            if (value > most) {
                res = key;
                most = value;
            }
        }
        return res;
    }
}
