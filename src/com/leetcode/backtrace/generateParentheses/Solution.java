package com.leetcode.backtrace.generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return res;
    }

    public void backtrack(String str, int begin, int end, int max) {
        if (str.length() == 2 * max) {
            System.out.println(str);
            res.add(str);
            return;
        }
        if (begin < max) {
            backtrack(str + "(", begin + 1, end, max);
        }
        if (end < begin) {
            backtrack(str + ")", begin, end + 1, max);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateParenthesis(2);
        System.out.println(s.res);
    }
}



