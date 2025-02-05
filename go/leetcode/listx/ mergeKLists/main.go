package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	fake := &ListNode{}
	fake.Next = head
	fast, slow := fake, fake
	length := 0
	for fast.Next != nil {
		fast = fast.Next
		length++
	}
	for i := 0; i < length-k%length; i++ {
		slow = slow.Next
	}
	fast.Next = fake.Next
	fake.Next = slow.Next
	slow.Next = nil
	return fake.Next
}

func main() {
	l1Array := []int{0, 1, 2}
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next
	}

	res := rotateRight(l1Head.Next, 4)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
