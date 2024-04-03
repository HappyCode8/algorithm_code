package com.leetcode.backtrace.increasingSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(0, nums);
        return res;
    }

    public void backtrack(int start, int[] nums) {
        if (temp.size() > 1) {
            res.add(new ArrayList<>(temp));
        }
        Set<Integer> brother = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            // 如果上一个加入子集的数比当前准备加入的数大，则接着尝试下一个数看能否找到比上一个数更大的数加入子集
            if (!temp.isEmpty() && temp.get(temp.size()-1) > nums[i]) {
                continue;
            }
            // 去重：如果父节点下面有2个一样的可能性则跳过后面的重复的子节点选择
            if (brother.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            brother.add(nums[i]);
            backtrack(i+1,nums);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubsequences(new int[]{4, 6, 7, 7}));
    }
}