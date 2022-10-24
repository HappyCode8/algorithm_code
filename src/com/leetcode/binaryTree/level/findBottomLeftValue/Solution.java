package com.leetcode.binaryTree.level.findBottomLeftValue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
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
        System.out.println(s.findBottomLeftValue(tr1[0]));
    }
}
