package com.leetcode.backtrace.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return res;
    }

    public void backtrack(int n, int start, int k) {
        if (k == temp.size()) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrack(n, i + 1, k);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.combine(4, 2));
    }
}
