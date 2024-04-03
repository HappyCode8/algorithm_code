package addtwonums

type ListNode struct {
	val  int
	next *ListNode
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
