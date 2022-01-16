package algorithm.sort;

import java.util.Arrays;

public class MySortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 6 ,3, 8};
        System.out.printf("排序前：" + Arrays.toString(arr) + "\n");
        bubbleSort(arr);
        selectSort(arr);
        System.out.printf("排序后：" + Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1 -i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            if (i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
