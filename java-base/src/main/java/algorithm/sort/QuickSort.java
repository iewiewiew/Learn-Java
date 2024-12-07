package algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序：
 * 快速排序的核心思想也是分治法，分而治之。
 * 选取第一个数为基准，将比基准小的数交换到前面，比基准大的数交换到后面，对左右区间重复第二步，直到各区间只有一个数
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 7, 1, 2, 0, 3, 6, 8};
        System.out.printf("排序前：" + Arrays.toString(arr) + "\n");
        quickSort(arr, 0, arr.length - 1);
        System.out.printf("排序后：" + Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //从右往左扫描，找到第一个比基准值小的元素
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //从左往右扫描，找到第一个比基准值大的元素
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }
}
