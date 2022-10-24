package com.datastructure.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//二叉树的中序遍历
public class InOrder {
    //使用递归方法遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorderTraversalHelp(root, res);
        return res;
    }

    public void inorderTraversalHelp(TreeNode root, List<Integer> res) {
        if (root != null) {
            inorderTraversalHelp(root.left, res);
            res.add(root.val);
            inorderTraversalHelp(root.right, res);
        }
    }

    //使用非递归方法遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> l = new ArrayList<>();
        TreeNode cur = root;
        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            l.add(cur.val);
            cur = cur.right;
        }
        return l;
    }

    public static void main(String[] args) {
        TreeNode[] tr1 = new TreeNode[3];
        tr1[0] = new TreeNode(1);
        tr1[1] = new TreeNode(2);
        tr1[2] = new TreeNode(3);
        tr1[0].setLeft(tr1[1]);
        tr1[0].setRight(tr1[2]);
        InOrder it = new InOrder();
        System.out.print(it.inorderTraversal1(tr1[0]));
        System.out.print(it.inorderTraversal2(tr1[0]));
    }
}
