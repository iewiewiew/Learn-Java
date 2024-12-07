package algorithm.sort;

import java.util.Arrays;


/**
 * 归并排序：
 * 将 n 个元素分成两个各含 n/2 个元素的子序列
 * 借助递归，两个子序列分别继续进行第一步操作，直到不可再分为止
 * 此时每一层递归都有两个子序列，再将其合并，作为一个有序的子序列返回上一层，再继续合并，全部完成之后得到的就是一个有序的序列
 * 关键在于两个子序列应该如何合并。假设两个子序列各自都是有序的，那么合并步骤就是：
 * 创建一个用于存放结果的临时数组，其长度是两个子序列合并后的长度
 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 比较两个指针所指向的元素，选择相对小的元素放入临时数组，并移动指针到下一位置
 * 重复步骤 3 直到某一指针达到序列尾
 * 将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 7, 1, 2, 0, 3, 6, 8};
        System.out.printf("排序前：" + Arrays.toString(arr) + "\n");
        mergeSort(arr, 0, arr.length - 1);
        System.out.printf("排序后：" + Arrays.toString(arr));
    }


    /**
     * 合并数组
     */
    public static void merge(int[] arr, int low, int middle, int high) {
        // 用于存储归并后的临时数组
        int[] temp = new int[high - low + 1];
        // 记录第一个数组中需要遍历的下标
        int i = low;
        // 记录第二个数组中需要遍历的下标
        int j = middle + 1;
        // 记录在临时数组中存放的下标
        int index = 0;
        // 遍历两个数组，取出小的数字，放入临时数组中
        while (i <= middle && j <= high) {
            // 第一个数组的数据更小
            if (arr[i] <= arr[j]) {
                // 把更小的数据放入临时数组中
                temp[index] = arr[i];
                // 下标向后移动一位
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        // 处理剩余未比较的数据
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        while (j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        // 把临时数组中的数据重新放入原数组
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }
    }


    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr, int low, int high) {
        int middle = (high + low) / 2;
        if (low < high) {
            // 处理左边数组
            mergeSort(arr, low, middle);
            // 处理右边数组
            mergeSort(arr, middle + 1, high);
            // 归并
            merge(arr, low, middle, high);
        }
    }
}
