package com.leetcode.backtrace.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, new ArrayList<>(), nums, used);
        return res;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(tempList);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
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

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1, 2, 3,4};
        System.out.print(s.permute(test));
    }
}
