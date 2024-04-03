package com.leetcode.binaryTree.iter.invertBinaryTree;

import java.util.Stack;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
			return null;
		}
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (s.size() > 0) {
            TreeNode node = s.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.right != null) {
				s.push(node.right);
			}
            if (node.left != null) {
				s.push(node.left);
			}
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode[] tr1 = new TreeNode[7];
        tr1[0] = new TreeNode(1);
        tr1[1] = new TreeNode(2);
        tr1[2] = new TreeNode(3);
        tr1[3] = new TreeNode(4);
        tr1[4] = new TreeNode(5);
        tr1[5] = new TreeNode(6);
        tr1[6] = new TreeNode(7);
        tr1[0].left = tr1[1];
        tr1[0].right = tr1[2];
        tr1[1].left = tr1[3];
        tr1[1].right = tr1[4];
        tr1[2].left = tr1[5];
        tr1[2].right = tr1[6];
        Solution s = new Solution();
        s.invertTree(tr1[0]);
        s.invertTree2(tr1[0]);
    }
}
