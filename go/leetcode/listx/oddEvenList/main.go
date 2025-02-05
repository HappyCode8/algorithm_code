package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func oddEvenList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	fake := &ListNode{}
	fake.Next = head.Next
	odd, even := head, head.Next
	for even != nil && even.Next != nil {
		odd.Next = even.Next
		odd = odd.Next
		even.Next = odd.Next
		even = even.Next
	}
	odd.Next = fake.Next
	return head
}

func main() {
	l1Array := []int{1, 2, 3, 4, 5} // 13524
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next
	}

	res := oddEvenList(l1Head.Next)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
