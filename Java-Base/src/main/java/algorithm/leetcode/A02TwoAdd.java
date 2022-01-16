package algorithm.leetcode;


/**
 * @Author weimenghua
 * @Date 2022-04-23 22:48
 * @Description 两数相加：给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 */
public class A02TwoAdd {
    public static void main(String[] args) {
        A02TwoAdd twoAdd = new A02TwoAdd();
//        ListNode l11 = new ListNode(1);
//        ListNode l12 = new ListNode(2);
//        ListNode l13 = new ListNode(3);
//        l11.next = l12;
//        l12.next = l13;
//        System.out.printf(twoAdd.addTwoNumbers(l11, l12).toString());
    }

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(0);
//        int carry = 0;
//        ListNode cur = dummy;
//        while (l1 != null || l2 != null || carry != 0) {
//            int s = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
//            carry = s / 10;
//            cur.next = new ListNode(s % 10);
//            cur = cur.next;
//            l1 = l1 == null ? null : l1.next;
//            l2 = l2 == null ? null : l2.next;
//        }
//        return dummy.next;
//    }
}
