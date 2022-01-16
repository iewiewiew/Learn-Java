package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author weimenghua
 * @Date 2022-02-26 11:10
 * @Description 最长无重复子串
 */
public class A03MostNoRepeat {
    public static void main(String[] args) {
        A03MostNoRepeat mostNoRepeat = new A03MostNoRepeat();
        String str = "abccca";
        int num = mostNoRepeat.lengthOfLongestSubstring(str);
        System.out.printf(String.valueOf(num));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
