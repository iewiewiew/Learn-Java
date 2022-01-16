package mix.oomtest;

/**
 * @author weimenghua
 * @time 2024-04-12 13:35
 * @description
 */
public class StackFlowTest {
    public static void main(String[] args) {
        // 3 栈内存溢出
        // 如果递归的深度超过了JVM允许的最大深度，可能会出现栈内存溢出问题。结果：java.lang.StackOverflowError
        doSamething();
    }
    private static void doSamething() {
        doSamething();
    }
}
