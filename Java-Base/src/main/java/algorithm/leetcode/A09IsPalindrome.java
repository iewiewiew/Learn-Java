package algorithm.leetcode;

/**
 * @author weimenghua
 * @time 2022-12-08 08:30
 * @description 回文数
 *
 * 题目描述
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 *
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class A09IsPalindrome {
    public static void main(String[] args) {
        A09IsPalindrome isPalindrome = new A09IsPalindrome();
        int aaa = 12321;
        int bbb = 123;
        boolean result = isPalindrome.isPalindrome(aaa);
        System.out.printf(String.valueOf(result));
    }

    public boolean isPalindrome(int x){
        if (x < 0) return false;
        int y = 0, t = x;
        while (t != 0){
            y = y * 10 + t % 10;
            System.out.printf("y====== " + String.valueOf(y) + "\n");
            System.out.printf("t====== " + String.valueOf(t) + "\n");
            t /= 10;
        }
        return x == y;
    }
}
