package datastructure;

/**
 * @Author weimenghua
 * @Date 2022-04-23 9:14
 * @Description 数组：数组是可以再内存中连续存储多个元素的结构，在内存中的分配也是连续的，数组中的元素通过数组下标进行访问，数组下标从0开始。
 */
public class ArrayDemo {
    public static void main(String[] args) {
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.arrayDemo();
    }

    public void arrayDemo(){
        int[] data = new int[100];
        data[0] = 666;
        System.out.printf(String.valueOf(data[0]));
    }
}
