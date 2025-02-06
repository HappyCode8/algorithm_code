package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	fake := &ListNode{Next: head}
	pre := fake
	for head != nil {
		tail := pre
		for i := 0; i < k; i++ {
			tail = tail.Next
			if tail == nil {
				return fake.Next
			}
		}
		next := tail.Next
		// 断开链表，pre在断开链表前，next在断开的链表后
		pre.Next, tail.Next = nil, nil
		head, tail = myReverse(head)
		// 把子链表接回原链表
		pre.Next = head
		tail.Next = next
		pre = tail
		head = tail.Next
	}
	return fake.Next
}

func myReverse(head *ListNode) (*ListNode, *ListNode) {
	if head == nil || head.Next == nil {
		return head, head
	}
	fake, p := &ListNode{Next: head}, head.Next
	for p != nil {
		head.Next = p.Next
		p.Next = fake.Next
		fake.Next = p
		p = head.Next
	}
	return fake.Next, head
}

func main() {
	l1Array := []int{1, 2, 3, 4, 5, 6, 7} // 13524
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next

	}

	res := reverseKGroup(l1Head.Next, 2)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
