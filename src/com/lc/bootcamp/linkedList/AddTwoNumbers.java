package com.lc.bootcamp.linkedList;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * Related Topics 链表 数学
 *
 * @author tianqi.xu
 * 2020/6/15
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
//        ListNode temp = result;
//        boolean carry = false;
//        while (l1 != null && l2 != null) {
//            temp.next = new ListNode();
//            temp = temp.next;
//
//            int sum = l1.val + l2.val;
//            sum = carry ? sum + 1 : sum;
//            carry = sum >= 10;
//            temp.val = carry ? sum % 10 : sum;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        if (carry) {
//            if (l1 == null && l2 == null) {
//                temp.val = 1;
//            } else if (l1 == null) {
//                temp.val = l2.val + 1;
//            } else {
//                temp.val = l1.val + 1;
//            }
//        }
        return result.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);

        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(6);
        node1.next.next = new ListNode(4);

        ListNode head = addTwoNumbers(node, node1);
        System.out.println(head);
    }

}
