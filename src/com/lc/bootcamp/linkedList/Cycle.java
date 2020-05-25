package com.lc.bootcamp.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * 进阶：
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * @author tianqi.xu
 * 2020/5/25
 */
public class Cycle {
    public boolean hasCycle(ListNode head) {
        int i = 0;
        Set<ListNode> nodeSet = new HashSet<>();
        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * O(1)（即，常量）内存，不产生新的set，使用追击问题解法
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode tail = head.next;

        while (tail != null && head != null) {
            if (tail == head) {
                return true;
            } else {
                head = head.next;
                tail = tail.next;
                if (tail == null) {
                    return false;
                } else {
                    tail = tail.next;
                }
            }
        }
        return false;
    }

}
