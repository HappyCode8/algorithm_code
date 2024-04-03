package com.leetcode.listx.mergeTwoLists;

class ListNode {
    int val;
    ListNode next;

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

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode virtualNode = new ListNode(-1);
        ListNode preNode=virtualNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                preNode.next = list1;
                list1=list1.next;
            }else{
                preNode.next = list2;
                list2=list2.next;
            }
            preNode=preNode.next;
        }
        if (list1 != null) {
            preNode.next=list1;
        }else if(list2 != null){
            preNode.next=list2;
        }
        return virtualNode.next;
    }

    public static void main(String[] args) {
        Solution twoSum = new Solution();
        ListNode listNode = new ListNode();
        ListNode l1 = listNode.createList(new int[]{1, 2, 4});
        ListNode l2 = listNode.createList(new int[]{1, 3, 4});
        ListNode res = twoSum.mergeTwoLists(l1, l2);
        listNode.printList(res);
    }
}
