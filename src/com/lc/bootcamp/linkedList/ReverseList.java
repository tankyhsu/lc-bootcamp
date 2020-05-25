package com.lc.bootcamp.linkedList;

/**
 * * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @author tianqi.xu
 * 2020/5/21
 */
public class ReverseList {

    /**
     * 迭代实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode right = head.next;
        ListNode left = head;
        left.next = null;


        while (right.next != null) {
            // 指向翻转
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }
        right.next = left;
        return right;
    }

    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode right = head.next;
        ListNode left = head;
        left.next = null;
        return reverse(left, right);
    }

    private static ListNode reverse(ListNode left, ListNode right) {
        if (right.next == null) {
            right.next = left;
            return right;
        } else {
            // 指向翻转
            ListNode temp = right.next;
            right.next = left;
            return reverse(right, temp);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseList2(head);
    }
}
