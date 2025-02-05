package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	l1Array := []int{1, 2}
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next
	}

	res := removeNthNodeFromEndOfList(l1Head.Next, 2)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}

func removeNthNodeFromEndOfList(head *ListNode, n int) *ListNode {
	start := &ListNode{}
	start.Next = head
	fast, slow := start, start
	for i := 1; i <= n; i++ {
		fast = fast.Next
	}
	for fast.Next != nil {
		slow = slow.Next
		fast = fast.Next
	}
	slow.Next = slow.Next.Next
	return start.Next
}
