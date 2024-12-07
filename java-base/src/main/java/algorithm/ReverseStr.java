package algorithm;

/**
 * @Author weimenghua
 * @Date 2022-02-19 11:10
 * @Description 反转字符串
 */
public class ReverseStr {
    public static void main(String[] args) {
        String str = "abcde";
        System.out.printf("反转字符串：%s", ReverseStr.reverse1(str) + "\n");
        System.out.printf("反转字符串：%s", ReverseStr.reverse2(str) + "\n");
        System.out.printf("反转字符串：%s", ReverseStr.reverse3(str));
    }


    /**
     * 利用 StringBuffer 或 StringBuilder 的 reverse 成员方法
     *
     * @param str
     * @return
     */
    public static String reverse1(String str) {
        String str1 = new StringBuilder(str).reverse().toString();
        return str1;
    }


    /**
     * 利用 String 的 toCharArray 方法先将字符串转化为 char 类型数组，然后将各个字符进行重新拼接
     *
     * @param str
     * @return
     */
    public static String reverse2(String str) {
        char[] arr = str.toCharArray();
        String reverse = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse += arr[i];

        }
        return reverse;
    }


    /**
     * 利用 String 的 CharAt 方法取出字符串中的各个字符
     *
     * @param str
     * @return
     */
    public static String reverse3(String str) {
        String reverse = "";
        for (int i = 0; i < str.length(); i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }
}
