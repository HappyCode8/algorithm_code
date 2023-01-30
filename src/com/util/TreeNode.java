package com.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode createTree(String[] nums) {
        TreeNode[] treeNodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if ("null".equals(nums[i])) {
                treeNodes[i] = null;
            } else {
                treeNodes[i] = new TreeNode(Integer.valueOf(nums[i]));
            }
        }
        for (int i = 0; i < treeNodes.length; i++) {
            if (treeNodes[i] == null) {
                continue;
            }
            treeNodes[i].left = 2 * i + 1 > treeNodes.length - 1 ? null : treeNodes[2 * i + 1];
            treeNodes[i].right = 2 * i + 2 > treeNodes.length - 1 ? null : treeNodes[2 * i + 2];
        }
        return treeNodes[0];
    }

    public void printTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            if (q.peek().left != null) {
                q.offer(q.peek().left);
            }
            if (q.peek().right != null) {
                q.offer(q.peek().right);
            }
            System.out.print(q.poll().val + " ");
        }
        System.out.println();
    }
}
