package algorithm;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author weimenghua
 * @Date 2022-02-19 9:01
 * @Description 找出一个字符串中所有大于n的回文串数量
 */
public class HuiWen {
    public static void main(String[] args) {
        String s = "上海自来水来自海上";
        boolean result = HuiWen.isHuiWen(s);
        System.out.printf("是否回文数：%s", result + "\n");

        List list = HuiWen.findAllHuiWen(s);
        for (int i = 0; i < list.size(); i++) {
            String text = (String) list.get(i);
            System.out.printf("所有回文数：%s", text + "\n");
            if (text.length() > 6) {
                System.out.printf("字符串大于n的回文数：%s", text + "\n");
            }
        }
    }


    /**
     * 判断是不是回文数
     *
     * @param s
     * @return
     */
    public static boolean isHuiWen(String s) {
        if (s == null || s.length() == 0)
            return false;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (arr[left++] != arr[right--])
                return false;
        }
        return true;
    }


    /**
     * 找出所有回文字符串
     *
     * @param s
     * @return
     */
    public static ArrayList<String> findAllHuiWen(String s) {
        ArrayList<String> list = new ArrayList<>();
        if (s == null || s.length() == 0)
            return list;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String subString = s.substring(i, j);
                if (isHuiWen(s) && !list.contains(subString)) {
                    list.add(subString);
                }
            }
        }
        return list;
    }
}
