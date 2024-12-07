package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author weimenghua
 * @date 2021-10-30 9:54
 * @Description 栈：栈是一种特殊的线性表，仅能在线性表的一端操作，栈顶允许操作，栈底不允许操作。 栈的特点是：先进后出，或者说是后进先出，从栈顶放入元素的操作叫入栈，取出元素叫出栈。栈的结构就像一个集装箱，越先放进去的东西越晚才能拿出来，所以，栈常应用于实现递归功能方面的场景，例如斐波那契数列。
 */
public class StackDemo {

    public static void main(String[] args) {
        StackDemo s = new StackDemo();

        for (int i = 100; i < 105; ++i) {
            s.push(i);
            System.out.println("入栈：" + i);
        }

        for (int i = 0; i < 4; ++i) {
            if (!s.isEmpty()) {
                System.out.println("栈顶：" + s.top());
            }
            System.out.println("删除栈：" + s.pop());
        }

        new StackDemo().stackDemo();

    }

    private final List<Integer> data;

    public StackDemo() {
        data = new ArrayList<>();
    }


    public void push(int x) {
        data.add(x);
    }


    public boolean isEmpty() {
        return data.isEmpty();
    }


    public int top() {
        return data.get(data.size() - 1);
    }


    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }

    public void stackDemo() {
        // 1. Initialize a stack.
        Stack<Integer> s = new Stack<>();

        // 2. Push new element.
        s.push(5);
        s.push(6);
        s.push(9);
        s.push(8);
        s.push(99);

        // 3. Check if stack is empty.
        if (s.empty() == true) {
            System.out.println("Stack is empty!");
            return;
        }

        // 4. Pop an element.
        s.pop();

        // 5. Get the top element.
        System.out.println("The top element is: " + s.peek());

        // 6. Get the size of the stack.
        System.out.println("The size is: " + s.size());
    }

}
