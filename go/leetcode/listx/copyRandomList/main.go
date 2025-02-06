package main

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}
	cur := head
	nodeMap := make(map[*Node]*Node)
	for cur != nil {
		nodeMap[cur] = &Node{Val: cur.Val}
		cur = cur.Next
	}
	cur = head
	for cur != nil {
		nodeMap[cur].Next = nodeMap[cur.Next]
		nodeMap[cur].Random = nodeMap[cur.Random]
		cur = cur.Next
	}
	return nodeMap[head]
}
