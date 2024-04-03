package com.util;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode createList(int[] nums){
        ListNode virtualNode = new ListNode(-1);
        ListNode preNode=virtualNode;
        for(int num:nums){
            preNode.next=new ListNode(num);
            preNode=preNode.next;
        }
        return virtualNode.next;
    }

    public void printList(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val+" ");
            listNode=listNode.next;
        }
    }
}
