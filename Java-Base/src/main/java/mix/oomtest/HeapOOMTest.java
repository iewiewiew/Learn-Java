package mix.oomtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weimenghua
 * @time 2024-04-12 11:28
 * @description OOM
 */

public class HeapOOMTest {
    public static void main(String[] args) {
        // 1 堆内存OOM
        // 创建了一个list集合，在一个死循环中不停往里面添加对象，结果：java.lang.OutOfMemoryError: Java heap space的堆内存溢出
        List<HeapOOMTest> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOOMTest());
        }
    }
}
