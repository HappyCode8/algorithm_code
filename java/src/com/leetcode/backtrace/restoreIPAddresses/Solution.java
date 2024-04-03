package com.leetcode.backtrace.restoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        backtrack(s, 0, 0);
        return res;
    }

    //s一直透传,start是从下一个位置开始搜,pointNum是增加的点数
    public void backtrack(String s, int start, int pointNum) {
        //逗点数量为3时，分隔结束
        if (pointNum == 4 && start == s.length()) {
            res.add(temp.substring(0, temp.length() - 1));
            return;
        }
        //加的点数已经到3了但是还不符合条件的返回
        if (start == s.length() || pointNum == 4) {
            return;
        }
        //向后最多截取3位
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            String substr = s.substring(start, i + 1);
            if (isValid(substr)) {
                temp.append(substr).append(".");
                backtrack(s, i + 1, pointNum + 1);
                temp.delete(temp.length() - substr.length() - 1, temp.length());
            }
        }
    }

    /*判断是不是合格的点分数*/
    public boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return num <= 255 && num > 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "25525511135";
        System.out.print(s.restoreIpAddresses(str));
    }
}
