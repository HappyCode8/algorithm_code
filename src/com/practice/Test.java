package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
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
}

public class Test {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root==null) {
            return res;
        }
        TreeNode cur = root;
        while (!stack.isEmpty()||cur != null) {
            while (cur!=null) {
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }

    public static void main(String[] args) {
        Test test = new Test();
        TreeNode tr1=new TreeNode(1);
        TreeNode tr2=new TreeNode(2);
        TreeNode tr3=new TreeNode(3);
        tr1.left=tr2;
        tr1.right=tr3;
        System.out.println(test.inorderTraversal(tr1));
    }
}
