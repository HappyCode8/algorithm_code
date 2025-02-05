package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	if list1 == nil {
		return list2
	}
	if list2 == nil {
		return list1
	}
	fake := &ListNode{}
	pre := fake
	for list1 != nil && list2 != nil {
		if list1.Val < list2.Val {
			pre.Next = list1
			list1 = list1.Next
		} else {
			pre.Next = list2
			list2 = list2.Next
		}
		pre = pre.Next
	}
	if list1 != nil {
		pre.Next = list1
	} else if list2 != nil {
		pre.Next = list2
	}
	return fake.Next
}

func main() {
	l1Array := []int{1, 2, 3, 4}
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next
	}

	l2Array := []int{1, 2, 3, 4}
	l2Head := &ListNode{}
	l2 := l2Head

	for _, l2Num := range l2Array {
		l2.Next = &ListNode{Val: l2Num}
		l2 = l2.Next
	}

	res := mergeTwoLists(l1Head.Next, l2Head.Next)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
