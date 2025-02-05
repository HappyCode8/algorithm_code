package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteDuplicates(head *ListNode) *ListNode {
	cur := head
	fake := &ListNode{}
	fake.Next = head
	before := fake
	for cur != nil {
		for cur.Next != nil && cur.Val == cur.Next.Val {
			cur = cur.Next
		}
		if before.Next == cur {
			before = before.Next
		} else {
			before.Next = cur.Next
		}
		cur = cur.Next
	}
	return fake.Next
}

func main() {
	l1Array := []int{1, 2, 3, 3, 4, 4, 5}
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next
	}

	res := deleteDuplicates(l1Head.Next)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
