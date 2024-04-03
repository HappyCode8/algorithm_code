package com.leetcode.listx.swapNodesInPairs;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head, q = head.next, r = null;
        ListNode start = new ListNode(-1);
        start.next = head;
        r = start;
        while (p != null && p.next != null) {
            p.next = q.next;
            q.next = p;
            r.next = q;
            r = p;
            p = p.next;
            if (p != null) {
                q = p.next;
            }
        }
        return start.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode now = start, pre = start, prepre;
        while (pre.next != null && pre.next.next != null) {
            prepre = pre;
            pre = pre.next;
            now = pre.next;
            prepre.next = now;
            pre.next = now.next;
            now.next = pre;
        }
        return start.next;
    }

    public static void main(String[] args) {
        ListNode[] ln = new ListNode[4];
        ln[0] = new ListNode(1);
        ln[1] = new ListNode(2);
        ln[2] = new ListNode(3);
        ln[3] = new ListNode(4);
        ln[0].next = ln[1];
        ln[1].next = ln[2];
        ln[2].next = ln[3];
        Solution s = new Solution();
        ListNode head = s.swapPairs2(ln[0]);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
