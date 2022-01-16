package algorithm.sort;

import java.util.Arrays;


/**
 * 基数排序：
 * 基数排序的原理是将整数按位数切割成不同的数字，然后按每个位数分别比较
 * 为此需要将所有待比较的数值统一为同样的数位长度，数位不足的数在高位补零
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 7, 1, 2, 0, 3, 6, 8};
        System.out.printf("排序前：" + Arrays.toString(arr) + "\n");
        radixSort(arr);
        System.out.printf("排序后：" + Arrays.toString(arr));
    }


    /**
     * 基数排序
     */
    public static void radixSort(int[] arr) {
        // 存放数组中的最大数字
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        // 计算最大数字是几位数
        int maxLength = (max + "").length();
        // 用于临时存储数据
        int[][] temp = new int[10][arr.length];
        // 用于记录在 temp 中相应的下标存放数字的数量
        int[] counts = new int[10];
        // 根据最大长度的数决定比较次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 每一个数字分别计算余数
            for (int j = 0; j < arr.length; j++) {
                // 计算余数
                int remainder = arr[j] / n % 10;
                // 把当前遍历的数据放到指定的数组中
                temp[remainder][counts[remainder]] = arr[j];
                // 记录数量
                counts[remainder]++;
            }
            // 记录取的元素需要放的位置
            int index = 0;
            // 把数字取出来
            for (int k = 0; k < counts.length; k++) {
                // 记录数量的数组中当前余数记录的数量不为 0
                if (counts[k] != 0) {
                    // 循环取出元素
                    for (int l = 0; l < counts[k]; l++) {
                        arr[index] = temp[k][l];
                        // 记录下一个位置
                        index++;
                    }
                    // 把数量置空
                    counts[k] = 0;
                }
            }
        }
    }
}
