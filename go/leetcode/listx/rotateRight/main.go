package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	start := &ListNode{}
	start.Next = head
	end := head.Next.Next
	fake := start
	for end != nil && end.Next != nil {
		swapHelper(start, end)
		start = start.Next.Next
		end = end.Next.Next
	}
	swapHelper(start, end)
	return fake.Next
}

func swapHelper(startNode *ListNode, endNode *ListNode) {
	firstNode := startNode.Next
	secondNode := startNode.Next.Next
	startNode.Next = secondNode
	secondNode.Next = firstNode
	firstNode.Next = endNode
}

func main() {
	l1Array := []int{1, 2, 3, 4}
	l1Head := &ListNode{}
	l1 := l1Head

	for _, l1Num := range l1Array {
		l1.Next = &ListNode{Val: l1Num}
		l1 = l1.Next
	}

	res := swapPairs(l1Head.Next)
	for res != nil {
		fmt.Println(res.Val)
		res = res.Next
	}
}
