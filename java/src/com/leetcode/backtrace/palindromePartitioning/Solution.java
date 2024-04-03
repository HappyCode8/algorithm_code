package com.leetcode.backtrace.palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> res = new ArrayList<>();
    public List<String> temp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, s);
        return res;
    }

    public void backtrack(int start, String s) {
        //当切割线切到了最后面，就说明找到了一种解法,start用以标记切割的位置
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        //从后边接续切
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                backtrack(i+1, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partition("aab"));
    }
}
