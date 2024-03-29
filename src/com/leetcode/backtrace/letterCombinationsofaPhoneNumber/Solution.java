package com.leetcode.backtrace.letterCombinationsofaPhoneNumber;

import java.util.LinkedList;
import java.util.List;

public class Solution {
public List<String> letterCombinations(String digits) {
	LinkedList<String> res= new LinkedList<>();
	if(digits.isEmpty()) {
		return res;
	}
	String[] map={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	res.add("");
	for(int i=0;i<digits.length();i++){
		int x=Character.getNumericValue(digits.charAt(i));
		while(res.peek().length()==i){
			String str=res.poll();
			for(char c:map[x].toCharArray()) {
				res.add(c+str);
			}
			System.out.println(i+" "+res);
		}
	}
	return res;	   
    }
	
public static void main(String[] args) {
	Solution s=new Solution();
	List<String> list=s.letterCombinations("221");
	System.out.println(list);
	}
}
