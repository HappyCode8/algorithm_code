package main

import "fmt"

/*
   java可以在类的属性中引用自己本身，是因为解释器会自动将其解释成指针类型
	go不行，编译器无法计算递归类型所需空间的大小，指针的大小是可以预估的
	type ListNode struct {
		val int
		next *ListNode
	}

	type A struct {
		b B
	}

	type B struct {
		a A
	}
这种也有问题，因为编译器不知道A和B的确切大小。所以以后在代码中为了防止出现这种错误，
在结构体中引用其他的结构体一般最好都设置为指针类型。
参考：https://blog.csdn.net/chen_0702/article/details/124515478
*/

type ListNode struct {
	val  int
	next *ListNode
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

func twoSum(l1 *ListNode, l2 *ListNode) *ListNode {
	sum := &ListNode{val: -1}
	head, singleSum := sum, 0
	for l1 != nil || l2 != nil {
		singleSum /= 10
		if l1 != nil {
			singleSum += l1.val
			l1 = l1.next
		}
		if l2 != nil {
			singleSum += l2.val
			l2 = l2.next
		}
		sum.next = &ListNode{val: singleSum % 10}
		sum = sum.next
	}
	if singleSum >= 10 {
		sum.next = &ListNode{val: 1}
	}
	return head.next
}

func main() {
	list1 := createList([]int{1, 2, 3, 4, 5})
	list2 := createList([]int{1, 2, 3, 4, 5})
	sum := twoSum(list1, list2)
	printList(sum)
}
