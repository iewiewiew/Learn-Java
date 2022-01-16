package algorithm.leetcode;

/**
 * @Author weimenghua
 * @Date 2022-03-06 20:53
 * @Description 斐波那契数（通常用F(n) 表示）形成的序列称为 斐波那契数列 。
 *
 * 题目描述
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 */
public class A10Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("i=%d  fib=%d", i, A10Fibonacci.fib(i));
            System.out.printf("\n");
        }
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
