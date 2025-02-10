package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var (
	result   [][]int
	tempList []int
)

func pathSum(root *TreeNode, sum int) [][]int {
	backtrack(root, sum)
	return result
}

func backtrack(start *TreeNode, sum int) {
	if start == nil {
		return
	}
	tempList = append(tempList, start.Val)
	if start.Left == nil && start.Right == nil && sum == start.Val {
		pathCopy := make([]int, len(tempList))
		copy(pathCopy, tempList)
		result = append(result, pathCopy)
	}
	backtrack(start.Left, sum-start.Val)
	backtrack(start.Right, sum-start.Val)
	tempList = tempList[:len(tempList)-1]
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
	fmt.Println(pathSum(tr1[0], 6))
	fmt.Println(pathSum(tr1[0], 7))
	fmt.Println(pathSum(tr1[0], 8))
}
