package com.leetcode.others.binaryTreeLevelOrderTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        List<List<Integer>> res=new LinkedList<>();
        if(root==null)return res;
        q.offer(root);        
        while(!q.isEmpty()){
        	int qSize=q.size();    
        	List<Integer> tempList=new LinkedList<>();
        	for(int i=0;i<qSize;i++){       		
        		if(q.peek().left!=null)q.offer(q.peek().left);
        		if(q.peek().right!=null)q.offer(q.peek().right);
        		tempList.add(q.poll().val);
        	}
        	res.add(tempList);
        }
        return res;
    }
	public static void main(String[] args){
		TreeNode[] tr1=new TreeNode[5];
		 tr1[0]=new TreeNode(3);
		 tr1[1]=new TreeNode(9);
		 tr1[2]=new TreeNode(20);
		 tr1[3]=new TreeNode(15);
		 tr1[4]=new TreeNode(7);

		 tr1[0].left=tr1[1];
		 tr1[0].right=tr1[2];
		 tr1[2].left=tr1[3];
		 tr1[2].right=tr1[4];
		
		 Solution s=new Solution();
		 System.out.print(s.levelOrder(tr1[0]));
	}
}
