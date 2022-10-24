package com.datastructure.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    //递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        preorderTraversal(root,list);
        return list;
    }
    public void preorderTraversal(TreeNode root,List<Integer> list) {
        if(root!=null) {
            list.add(root.val);
            preorderTraversal(root.left,list);
            preorderTraversal(root.right,list);
        }
    }
    //非递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }
}
