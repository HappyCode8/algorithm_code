package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	leftDepth := maxDepth(root.Left)
	rightDepth := maxDepth(root.Right)
	if leftDepth > rightDepth {
		return leftDepth + 1
	}
	return rightDepth + 1
}

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	leftDepth := maxDepth(root.Left)
	rightDepth := maxDepth(root.Right)
	if leftDepth-rightDepth > 1 || rightDepth-leftDepth > 1 {
		return false
	}
	return isBalanced(root.Left) && isBalanced(root.Right)
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
	fmt.Println(isBalanced(tr1[0]))
}
