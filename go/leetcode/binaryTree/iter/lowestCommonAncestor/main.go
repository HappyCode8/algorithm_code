package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil || root == p || root == q {
		return root
	}
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	if left != nil && right != nil {
		return root
	}
	if left != nil {
		return left
	}
	return right
}

func main() {
	tr1 := make([]*TreeNode, 7)
	tr1[0] = &TreeNode{Val: 1}
	tr1[1] = &TreeNode{Val: 2}
	tr1[2] = &TreeNode{Val: 2}
	tr1[3] = &TreeNode{Val: 3}
	tr1[4] = &TreeNode{Val: 4}
	tr1[5] = &TreeNode{Val: 4}
	tr1[6] = &TreeNode{Val: 3}
	tr1[0].Left = tr1[1]
	tr1[0].Right = tr1[2]
	tr1[1].Left = tr1[3]
	tr1[1].Right = tr1[4]
	tr1[2].Left = tr1[5]
	tr1[2].Right = tr1[6]
	fmt.Println(lowestCommonAncestor(tr1[0], tr1[3], tr1[6]).Val)
}
