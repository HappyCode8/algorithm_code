package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func hasPathSum(root *TreeNode, sum int) bool {
	if root == nil {
		return false
	}
	sum -= root.Val
	if root.Left == nil && root.Right == nil && sum == 0 {
		return true
	}
	return hasPathSum(root.Left, sum) || hasPathSum(root.Right, sum)
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
	fmt.Println(hasPathSum(tr1[0], 6))
	fmt.Println(hasPathSum(tr1[0], 7))
	fmt.Println(hasPathSum(tr1[0], 8))
}
