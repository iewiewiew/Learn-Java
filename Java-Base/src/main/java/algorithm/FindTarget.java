package algorithm;

/**
 * @Author weimenghua
 * @Date 2022-06-15 22:11
 * @Description 无序数组, 有正有负, 输出和为10的所有组合。
 */


public class FindTarget {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int p = 0, q = 9;
        int target = 10;
        for (int j = 0; j < a.length - 1; j++) {
            for (int k = 0; k < a.length - 1 - j; k++) {
                if (a[k] > a[k + 1]) {
                    int temp = a[k + 1];
                    a[k + 1] = a[k];
                    a[k] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        while (p != q) {
            int sum = a[p] + a[q];
            if (sum > 10) {
                q--;
            }
            if (sum < 10) {
                p++;
            } else {
                System.out.println(a[p] + "+" + a[q] + "=" + "10");
            }
            q--;
            p++;
        }
    }
}
