package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序：
 * 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
 * 以此类推，直到所有元素均排序完毕
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 7, 1, 2, 0, 3, 6, 8};
        System.out.printf("排序前：" + Arrays.toString(arr) + "\n");
        selectsort(arr);
        System.out.printf("排序后：" + Arrays.toString(arr));
    }


    public static void selectsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i; //最小元素的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j; //找最小值
                }
            }
            //交换位置
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
