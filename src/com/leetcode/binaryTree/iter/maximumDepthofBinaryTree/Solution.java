package com.leetcode.binaryTree.iter.maximumDepthofBinaryTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);
        return maxL > maxR ? maxL + 1 : maxR + 1;
    }

    public static void main(String[] args) {
        TreeNode[] tr1 = new TreeNode[7];
        tr1[0] = new TreeNode(1);
        tr1[1] = new TreeNode(2);
        tr1[2] = new TreeNode(2);
        tr1[3] = new TreeNode(3);
        tr1[4] = new TreeNode(4);
        tr1[5] = new TreeNode(4);
        tr1[6] = new TreeNode(3);
        tr1[0].left = tr1[1];
        tr1[0].right = tr1[2];
        tr1[1].left = tr1[3];
        tr1[1].right = tr1[4];
        tr1[2].left = tr1[6];
        tr1[2].right = tr1[5];
        Solution s = new Solution();
        System.out.println(s.maxDepth(tr1[0]));
    }
}