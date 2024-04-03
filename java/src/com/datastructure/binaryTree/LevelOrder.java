package com.datastructure.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的层次遍历,也即广度优先遍历
public class LevelOrder {
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

    public static void main(String[] args) {
        TreeNode[] tr1 = new TreeNode[5];
        tr1[0] = new TreeNode(1);
        tr1[1] = new TreeNode(2);
        tr1[2] = new TreeNode(3);
        tr1[3] = new TreeNode(4);
        tr1[4] = new TreeNode(5);
        tr1[0].setLeft(tr1[1]);
        tr1[0].setRight(tr1[2]);
        tr1[2].setLeft(tr1[3]);
        tr1[2].setRight(tr1[4]);
        LevelOrder lot = new LevelOrder();
        System.out.print(lot.levelOrder(tr1[0]));
    }
}
