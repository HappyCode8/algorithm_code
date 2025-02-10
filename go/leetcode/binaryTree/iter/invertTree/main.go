package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func invertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	// 使用切片模拟栈
	stack := []*TreeNode{root}
	for len(stack) > 0 {
		// 弹出栈顶元素
		node := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		// 交换左右子节点
		temp := node.Left
		node.Left = node.Right
		node.Right = temp
		// 若右子节点不为空，将其压入栈
		if node.Right != nil {
			stack = append(stack, node.Right)
		}
		// 若左子节点不为空，将其压入栈
		if node.Left != nil {
			stack = append(stack, node.Left)
		}
	}
	return root
}

func invertTree2(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	left := invertTree2(root.Left)
	right := invertTree2(root.Right)
	root.Left = right
	root.Right = left
	return root
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
	//newRoot := invertTree(tr1[0])
	newRoot2 := invertTree(tr1[0])
	queue := []*TreeNode{newRoot2}
	for len(queue) > 0 {
		queueSize := len(queue)
		for i := 0; i < queueSize; i++ {
			node := queue[0]
			queue = queue[1:]
			fmt.Println(node.Val)
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
	}
}
