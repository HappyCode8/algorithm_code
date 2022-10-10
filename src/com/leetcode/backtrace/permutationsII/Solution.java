package com.leetcode.backtrace.permutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://blog.csdn.net/weixin_40714134/article/details/107177973
public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
	    return list;      
    }
	public void backtrack(List<List<Integer>> list,List<Integer> tempList,int[] nums,boolean[] used){
		if(tempList.size()==nums.length) {
			list.add(new ArrayList<>(tempList));
		} else{
			for(int i = 0; i < nums.length; i++){
				//1.想同数刚刚被使用 2.相同数刚刚被撤销
				// 注意这里的!used[i - 1]保留了上一层的值，因为一样的数字上一层是true的时候被保留了下来，同一层是false的时候被跳过了
	            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i - 1])) {
					continue;
				}
	            used[i] = true; 
	            tempList.add(nums[i]);
	            backtrack(list, tempList, nums, used);
	            used[i] = false; 
	            tempList.remove(tempList.size() - 1);
	        }
		}
	}

	public static void main(String[] args){
		Solution s=new Solution();
		int[] test={1,2,1};
		System.out.print(s.permuteUnique(test));
	}
}
