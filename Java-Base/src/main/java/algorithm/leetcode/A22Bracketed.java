package algorithm.leetcode;

import java.util.Stack;

/**
 * @Author weimenghua
 * @Date 2022-02-27 9:53
 * @Description 有效括号
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 */
public class A22Bracketed {
    public static void main(String[] args) {
        A22Bracketed bracketed = new A22Bracketed();
        String s = "({[]})";
        String str = String.valueOf(bracketed.isValid(s));
        System.out.printf("是否有效括号：" + str);
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        //使用foreach循环
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
