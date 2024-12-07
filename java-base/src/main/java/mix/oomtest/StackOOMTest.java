package mix.oomtest;

/**
 * @author weimenghua
 * @time 2024-04-12 11:37
 * @description
 */

public class StackOOMTest {
    public static void main(String[] args) {
        // 2 栈内存OOM
        // 使用一个死循环不停创建线程，导致系统产生了大量的线程。结果：java.lang.OutOfMemoryError: unable to create new native thread
        while (true) {
            new Thread().start();
        }
    }
}
