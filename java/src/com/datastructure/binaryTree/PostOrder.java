package com.datastructure.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    //递归
    public List<Integer>  postorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        preorderTraversal(root,list);
        return list;
    }
    public void preorderTraversal(TreeNode root,List<Integer> list) {
        if(root!=null) {
            preorderTraversal(root.left,list);
            preorderTraversal(root.right,list);
            list.add(root.val);
        }
    }
    //非递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
