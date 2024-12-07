package algorithm.leetcode;

/**
 * @author weimenghua
 * @time 2022-12-04 09:40
 * @description 整数反转
 *
 * 题目描述
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 *
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 *
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 */
public class A07ReverseInt {
    public static void main(String[] args) {
        A07ReverseInt reverseInt = new A07ReverseInt();
        int res = reverseInt.reverseInt(123456);
        System.out.printf(String.valueOf(res));
    }

    public int reverseInt(int x){
        int res = 0;
        while(x != 0) {
            //每次取末尾数
            int tmp = x % 10;
            //判断是否大于最大32位整数
            if (res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            //判断是否小于最小32位整数
            if (res < -214748364 || (res == -214748364 && tmp < -8)) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}
