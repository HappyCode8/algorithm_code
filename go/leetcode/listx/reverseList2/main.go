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

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	fake := &ListNode{}
	fake.Next = head
	pre := fake
	for i := 1; i < left; i++ {
		pre = pre.Next
	}
	start, then := pre.Next, pre.Next.Next
	for i := left; i < right; i++ {
		start.Next = then.Next
		then.Next = pre.Next
		pre.Next = then
		then = start.Next
	}
	return fake.Next
}

func main() {
	l1Array := []int{1, 2, 3, 4, 5, 6, 7} // 13524
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next
	}

	res := reverseBetween(l1Head.Next, 3, 5)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
