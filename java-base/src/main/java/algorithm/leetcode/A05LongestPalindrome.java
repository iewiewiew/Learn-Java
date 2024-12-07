package algorithm.leetcode;

/**
 * @author weimenghua
 * @time 2022-12-03 16:25
 * @description 最长回文子串
 *
 * 题目描述
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class A05LongestPalindrome {
    public static void main(String[] args) {
        String str = "adbbda";
        A05LongestPalindrome longestPalindrome = new A05LongestPalindrome();
        System.out.printf(longestPalindrome.longestPalindrome(str));
    }

    /**
     * 解法
     * 动态规划法。
     * 设 dp[i][j] 表示字符串 s[i..j] 是否为回文串。
     * 当 j - i < 2，即字符串长度为 2 时，只要 s[i] == s[j]，dp[i][j] 就为 true。
     * 当 j - i >= 2，dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]。
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int mx = 1, start = 0;
        for(int j = 0; j < n; ++j){
            for(int i = 0; i<=j; ++i){
                if (j - i < 2){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = dp[i + 1][j -1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && mx < j -i +1){
                    mx = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + mx);
    }
}
