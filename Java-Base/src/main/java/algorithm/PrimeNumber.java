package algorithm;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author weimenghua
 * @Date 2022-02-19 11:34
 * @Description 求一个区间的素数
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int tmp = PrimeNumber.primeCount(1, 100);
        System.out.printf("素数个数：%d", tmp);
    }

    public static int primeCount(int a, int b) {
        List<Integer> list = new ArrayList<Integer>();
        int loop = 0;
        int i = 0;
        int j = 0;
        for (i = a; i <= b; i++) {
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j >= i) {
                list.add(i);
                loop++;
            }
        }
        for (i = 0; i < list.size(); i++) {
            System.out.printf("第%d个 素数%d ", i+1, list.get(i));
            System.out.printf("\n");
        }
        return loop;
    }
}
