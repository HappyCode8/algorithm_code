package com.leetcode.rotateString;

public class Solution {
	public boolean rotateString(String A, String B) {
       return (A.length()==B.length()&&(A+A).contains(B));
    }
	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.rotateString("abcde", "cdeab"));
	}
}
