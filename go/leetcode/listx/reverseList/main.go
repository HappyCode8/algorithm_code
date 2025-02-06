package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

// 前中后尾 中指尾，后指中，前指后
func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	fake := &ListNode{}
	fake.Next = head
	p := head.Next
	for p != nil {
		head.Next = p.Next
		p.Next = fake.Next
		fake.Next = p
		p = head.Next
	}
	return fake.Next
}

func reverseList2(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	next := head.Next
	newHead := reverseList2(next)
	next.Next = head
	head.Next = nil
	return newHead
}

func main() {
	l1Array := []int{1, 2, 3, 4, 5} // 13524
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next
	}

	res := reverseList(l1Head.Next)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
