package com.wmh.test;

import java.util.Arrays;

/**
 * @author weimenghua
 * @time 2024-12-05 17:50
 * @description
 */
public class TestDemo {
    public static void main(String[] args) {

        // 用户输入数组长度
        int length = 80;

        // 创建指定长度的数组
        int[] array = new int[length];

        // 按递增赋值
        for (int i = 0; i < length; i++) {
            array[i] = i + 1; // 从 1 开始赋值
        }

        // 输出数组
        System.out.println(Arrays.toString(array));
    }
}
