package addtwonums

import (
	"fmt"
	"testing"
)

func Test_addTwoNums(t *testing.T) {
	list1 := createList([]int{1, 2, 3, 4, 5})
	list2 := createList([]int{1, 2, 3, 4, 5})
	sum := twoSum(list1, list2)
	printList(sum)
}

func createList(nums []int) *ListNode {
	l := &ListNode{}
	t := l
	for _, v := range nums {
		t.next = &ListNode{val: v}
		t = t.next
	}
	return l.next
}

func printList(node *ListNode) {
	for node != nil {
		fmt.Printf("%d ", node.val)
		node = node.next
	}
}
