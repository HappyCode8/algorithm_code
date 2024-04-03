package com.leetcode.binaryTree.iter.pathSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
	List<Integer> temp=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        backtrack(root, sum);
        return res;
    }

    public void backtrack(TreeNode start, int sum) {
        if (start == null) {
            return;
        }
        temp.add(start.val);
        if (start.left == null && start.right == null && sum == start.val) {
            res.add(new ArrayList<>(temp));
        }
        backtrack(start.left, sum - start.val);
        backtrack(start.right, sum - start.val);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode[] tr1 = new TreeNode[6];
        tr1[0] = new TreeNode(1);
        tr1[1] = new TreeNode(2);
        tr1[2] = new TreeNode(3);
        tr1[3] = new TreeNode(3);
        tr1[4] = new TreeNode(5);
        tr1[5] = new TreeNode(2);
        tr1[0].left = tr1[1];
        tr1[0].right = tr1[2];
        tr1[1].left = tr1[3];
        tr1[1].right = tr1[4];
        tr1[2].left = tr1[5];
        Solution s = new Solution();
        System.out.print(s.pathSum(tr1[0], 6));
    }
}
