package com.datastructure.listx.reverseLinkedList;

/**
 * fake head p
 *   □→  □→  □→□→□→□→□→□→□→□→
 * */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeNode = new ListNode(-1);
        fakeNode.next = head;
        ListNode p = head.next;
        while (p != null) {
            //head与p对调
            head.next = p.next;
            p.next = fakeNode.next;
            //fake重新指向节点头
            fakeNode.next = p;
            //p指向新的节点开始下一轮
            p = head.next;
        }
        return fakeNode.next;
    }

    //递归方法
    /**
     * head next
     *   □→  □→   □→□→□→□→□→□→□→
     * */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList2(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode[] ln = new ListNode[7];
        ln[0] = new ListNode(1);
        ln[1] = new ListNode(2);
        ln[2] = new ListNode(3);
        ln[3] = new ListNode(4);
        ln[4] = new ListNode(5);
        ln[5] = new ListNode(6);
        ln[6] = new ListNode(7);
        ln[0].next = ln[1];
        ln[1].next = ln[2];
        ln[2].next = ln[3];
        ln[3].next = ln[4];
        ln[4].next = ln[5];
        ln[5].next = ln[6];
        ln[6].next = null;
        Solution s = new Solution();
        ListNode p = s.reverseList(ln[0]);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
