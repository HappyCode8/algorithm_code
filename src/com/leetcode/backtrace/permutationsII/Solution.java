package com.leetcode.backtrace.permutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //注意这里要排序
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length]);
        return result;
    }

    public void backtrack(int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //1.想同数刚刚被使用 2.相同数刚刚被撤销
            // 要么这个数字被用过了，要么与前一个相等而且前一个也没被用过
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(nums, used);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1, 2, 1};
        System.out.print(s.permuteUnique(test));
    }
}
