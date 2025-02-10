package main

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var max = 0

func diameterOfBinaryTree(root *TreeNode) int {
	helper(root)
	return max
}

func helper(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left := helper(root.Left)
	right := helper(root.Right)
	if left+right > max {
		max = left + right
	}
	if left > right {
		return left + 1
	} else {
		return right + 1
	}
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
	fmt.Println(diameterOfBinaryTree(tr1[0]))
}
