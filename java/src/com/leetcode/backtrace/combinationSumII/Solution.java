package com.leetcode.backtrace.combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            //对同层的数据去重而不是对同一分支上的数据去重
            if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
            tempList.add(nums[i]);
            //下一次是从下一个位置搜，目标是remain - nums[i]
            backtrack(nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> l = s.combinationSum2(test, 8);
        System.out.print(l);
    }
}
