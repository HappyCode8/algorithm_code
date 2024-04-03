package com.leetcode.backtrace.combinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1,  n, k);
        return res;
    }

    public void backtrack(int start, int target, int k) {
        if (target < 0 || (temp.size() == k && target != 0)) {
            return;
        }
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(i + 1, target - i, k);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.combinationSum3(3, 9));
    }
}
