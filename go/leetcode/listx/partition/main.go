package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func partition(head *ListNode, x int) *ListNode {
	fake1, fake2 := &ListNode{}, &ListNode{}
	cur1, cur2 := fake1, fake2
	for head != nil {
		if head.Val < x {
			cur1.Next = head
			cur1 = head
		} else {
			cur2.Next = head
			cur2 = head
		}
		head = head.Next
	}
	cur1.Next = fake2.Next
	cur2.Next = nil
	return fake1.Next
}

func main() {
	l1Array := []int{1, 4, 3, 2, 5, 2} //122435
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next
	}

	res := partition(l1Head.Next, 3)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
