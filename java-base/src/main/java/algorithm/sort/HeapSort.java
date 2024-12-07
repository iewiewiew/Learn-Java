package algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序：
 * 1、根据初始数组构造堆
 * 2、每次交换第一个和最后一个元素，然后将除最后一个元素以外的其他元素重新调整为大顶堆
 * 重复以上两个步骤，直到没有元素可操作，就完成排序了。
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 7, 1, 2, 0, 3, 6, 8};
        System.out.printf("排序前：" + Arrays.toString(arr) + "\n");
        heapSort(arr);
        System.out.printf("排序后：" + Arrays.toString(arr));
    }


    /**
     * 转化为大顶堆
     * @param arr 待转化的数组
     * @param size 待调整的区间长度
     * @param index 结点下标
     */
    public static void maxHeap(int[] arr, int size, int index) {
        //左子结点
        int leftNode = 2 * index + 1;
        //右子结点
        int rightNode = 2 * index + 2;
        int max = index;
        //和两个子结点分别对比，找出最大的结点
        if (leftNode < size && arr[leftNode] > arr[max]) {
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }
        //交换位置
        if (max != index) {
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //因为交换位置后有可能使子树不满足大顶堆条件，所以要对子树进行调整
            maxHeap(arr, size, max);
        }
    }


    public static void heapSort(int[] arr) {
        //开始位置是最后一个非叶子结点，即最后一个结点的父结点
        int start = (arr.length - 1) / 2;
        //调整为大顶堆
        for (int i = start; i >= 0; i--) {
            HeapSort.maxHeap(arr, arr.length, i);
        }
        //先把数组中第 0 个位置的数和堆中最后一个数交换位置，再把前面的处理为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeap(arr, i, 0);
        }
    }
}
