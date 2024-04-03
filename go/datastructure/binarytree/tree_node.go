package binarytree

type TreeNode struct {
	val   int
	left  *TreeNode
	right *TreeNode
}

/*
public List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            if (q.peek().left != null) {
                q.offer(q.peek().left);
            }
            if (q.peek().right != null) {
                q.offer(q.peek().right);
            }
            res.add(q.poll().val);
        }
        return res;
    }
*/
