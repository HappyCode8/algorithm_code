package hasCycle_getIntersectionNode

type ListNode struct {
	Val  int
	Next *ListNode
}

// 是否有环
func hasCycle(head *ListNode) bool {
	if head == nil {
		return false
	}
	fast, slow := head, head
	for slow.Next != nil && fast.Next != nil && fast.Next.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			return true
		}
	}
	return false
}

// 两个链表是否相交
func getIntersectionNode(headA, headB *ListNode) *ListNode {
	p, q := headA, headB
	for p != q {
		if p == nil {
			p = headB
		} else {
			p = p.Next
		}

		if q == nil {
			q = headA
		} else {
			q = q.Next
		}
	}
	return p
}
