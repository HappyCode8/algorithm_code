package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode) {
	if root == nil {
		return
	}

	// 递归展开左子树
	flatten(root.Left)
	// 递归展开右子树
	flatten(root.Right)

	// 保存右子树
	right := root.Right
	// 将左子树移到右子树的位置
	root.Right = root.Left
	root.Left = nil

	// 找到当前右子树的末尾
	curr := root
	for curr.Right != nil {
		curr = curr.Right
	}

	// 将原来的右子树接到当前右子树的末尾
	curr.Right = right
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
	flatten(tr1[0])
}
