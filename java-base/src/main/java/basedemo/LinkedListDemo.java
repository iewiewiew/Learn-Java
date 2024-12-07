package basedemo;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author weimenghua
 * @time 2022-02-28 11:30
 * @description
 * Java LinkedList（链表） 类似于 ArrayList，是一种常用的数据容器。
 * 与 ArrayList 相比，LinkedList 的增加和删除的操作效率更高，而查找和修改的操作效率较低。
 * 以下情况使用 ArrayList :
 *      频繁访问列表中的某一个元素。
 *      只需要在列表末尾进行添加和删除元素操作。
 * 以下情况使用 LinkedList :
 *      你需要通过循环迭代来访问列表中的某些元素。
 *      需要频繁的在列表开头、中间、末尾等位置进行添加和删除元素操作。
 * LinkedList 继承了 AbstractSequentialList 类。
 * LinkedList 实现了 Queue 接口，可作为队列使用。
 * LinkedList 实现了 List 接口，可进行列表的相关操作。
 * LinkedList 实现了 Deque 接口，可作为队列使用。
 * LinkedList 实现了 Cloneable 接口，可实现克隆。
 * LinkedList 实现了 java.io.Serializable 接口，即可支持序列化，能通过序列化去传输。
 */
public class LinkedListDemo {
    public static void main(String[] args) {

    }

    @Test
    public void test(){
        LinkedList<String> ls = new LinkedList<String>();
        ls.add("一");
        ls.add("一");
        ls.add("一");
        ls.add("二");
        ls.add("三");
        System.out.printf(String.valueOf(ls));

        for (int i = 0; i < ls.size(); i++) {
            System.out.printf("\n" + ls.get(i) + "\n");
        }
    }
}
