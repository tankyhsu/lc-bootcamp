package com.lc.bootcamp.linkedList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cursor = head.next;

        if (cursor == null) {
            return n >= 1 ? null : head;
        }

        int len = 2;
        while (cursor.next != null) {
            len++;
            cursor = cursor.next;
        }
        len -= n;
        if (len < 0) {
            return head;
        } else if (len == 0) {
            return head.next;
        }
        cursor = head;
        for (int i = 1; i < len; i++) {
            cursor = cursor.next;
        }

        ListNode temp = cursor.next;
        cursor.next = temp == null ? null : temp.next;
//        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        removeNthFromEnd(head, 2);
    }
}