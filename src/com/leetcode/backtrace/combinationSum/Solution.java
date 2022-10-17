package com.leetcode.backtrace.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
	List<Integer> tempList=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return result;
    }

    public void backtrack(int[] nums, int remain, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            //下一次还是从当前位置搜，这里注意的是传start的原因是避免从开头重新搜重复，目标是remain - nums[i]
            backtrack(nums, remain - nums[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {2, 3, 6, 7};
        List<List<Integer>> l = s.combinationSum(test, 7);
        System.out.print(l);
    }
}
