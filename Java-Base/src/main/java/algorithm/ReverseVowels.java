package algorithm;

/**
 * @Author weimenghua
 * @Date 2022-03-12 8:37
 * @Description 反转字符串中的元音字母。示例：输入: “leetcode” 输出: “leotcede”。
 */
public class ReverseVowels {
    public static void main(String[] args) {
        String str = "leetcode";
        System.out.printf(ReverseVowels.reverseVowels(str));
    }


    public static String reverseVowels(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] ss = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && (ss[j] != 'a' && ss[j] != 'e' && ss[j] != 'i' && ss[j] != 'o' && ss[j] != 'u' && ss[j] != 'A' && ss[j] != 'E' && ss[j] != 'I' && ss[j] != 'O' && ss[j] != 'U'))
                j--;
            while (i < j && (ss[i] != 'a' && ss[i] != 'e' && ss[i] != 'i' && ss[i] != 'o' && ss[i] != 'u' && ss[i] != 'A' && ss[i] != 'E' && ss[i] != 'I' && ss[i] != 'O' && ss[i] != 'U'))
                i++;
            if (ss[i] != ss[j]) {
                char temp = ss[i];
                ss[i] = ss[j];
                ss[j] = temp;
            }
            i++;
            j--;
        }
        String str = String.valueOf(ss);
        return str;
    }
}
