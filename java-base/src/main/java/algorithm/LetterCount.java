package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author weimenghua
 * @Date 2022-03-15 13:20
 * @Description 给定一个字符串str，返回str的统计字符串。例如“aaabbbbcccd”的统计字符串为“a_3_b_4_c_3_d_1
 */
public class LetterCount {

    public static void main(String[] args) {
        LetterCount test = new LetterCount();
        test.countChar("abbcccddddeeeee"); // 注：不支持中文
    }


    // 统计结果用，采用Character即char做键（Key）
    private Map<Character, Integer> countMap = new HashMap<Character, Integer>();

    public void countChar(String str) {
        char[] chars = str.toCharArray();// 将字符串转换成字符char数组
        // 循环，开始统计
        for (char ch : chars) {
            // 判断字符是否存在
            if (!countMap.containsKey(ch)) {
                // 不存在，在Map中加一个，并设置初始值为0
                countMap.put(ch, 0);
            }
            // 计数，将值+1
            int count = countMap.get(ch);
            countMap.put(ch, count + 1);
        }

        // 输出结果
        Set<Character> keys = countMap.keySet();
        for(Character ch : keys){
            System.out.println("字符" + ch + "出现次数：" + countMap.get(ch));
        }
    }
}
