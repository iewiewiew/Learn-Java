package algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序：
 * 把记录按步长gap分组，对每组记录采用直接插入排序方法进行排序；
 * 随着步长逐渐减小，所分成的组包含的记录越来越多；
 * 当步长值减小到1时，整个数据合成一组，构成一组有序记录，完成排序；
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 7, 1, 2, 0, 3, 6, 8};
        System.out.printf("排序前：" + Arrays.toString(arr) + "\n");
        shellSort(arr);
        System.out.printf("排序后：" + Arrays.toString(arr));
    }


    public static void shellSort(int[] arr) {
        //step:步长
        for (int step = arr.length / 2; step > 0; step /= 2) {
            System.out.printf("step：" + step + "\n");
            //对一个步长区间进行比较 [step,arr.length)
            for (int i = step; i < arr.length; i++) {
                int value = arr[i];
                int j;

                //对步长区间中具体的元素进行比较
                for (j = i - step; j >= 0 && arr[j] > value; j -= step) {
                    //j为左区间的取值，j+step为右区间与左区间的对应值
                    arr[j + step] = arr[j];
                }
                //此时step为一个负数，[j + step]为左区间上的初始交换值
                arr[j + step] = value;
            }
        }
    }
}
