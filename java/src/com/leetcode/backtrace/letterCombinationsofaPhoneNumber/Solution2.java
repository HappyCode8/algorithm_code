package com.leetcode.backtrace.letterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> res = new ArrayList<>();
    public StringBuilder temp = new StringBuilder();
    String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    public void backtrack(String digits, int index) {
        if (temp.toString().length() == digits.length()) {
            res.add(temp.toString());
            return;
        }
        String str = map[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtrack(digits, index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.letterCombinations(""));
    }
}
