package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isCompleteTree(root *TreeNode) bool {
	if root == nil {
		return true
	}
	queue := []*TreeNode{root}
	// 标记是否遇到过空节点
	hasMetNil := false

	for len(queue) > 0 {
		node := queue[0]
		queue = queue[1:]

		if node == nil {
			hasMetNil = true
		} else {
			// 如果已经遇到过空节点，再次遇到非空节点，则不是完全二叉树
			if hasMetNil {
				return false
			}
			// 将左右子节点加入队列
			queue = append(queue, node.Left)
			queue = append(queue, node.Right)
		}
	}
	return true
}

func main() {
	tr1 := make([]*TreeNode, 7)
	tr1[0] = &TreeNode{Val: 1}
	tr1[1] = &TreeNode{Val: 2}
	tr1[2] = &TreeNode{Val: 3}
	tr1[3] = &TreeNode{Val: 4}
	tr1[4] = &TreeNode{Val: 5}
	tr1[5] = &TreeNode{Val: 6}
	tr1[6] = &TreeNode{Val: 7}
	tr1[0].Left = tr1[1]
	tr1[0].Right = tr1[2]
	tr1[1].Left = tr1[3]
	tr1[1].Right = tr1[4]
	tr1[2].Left = tr1[5]
	tr1[2].Right = tr1[6]
	fmt.Println(isCompleteTree(tr1[0]))
}
