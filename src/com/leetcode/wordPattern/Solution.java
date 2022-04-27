package com.leetcode.wordPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
	 public boolean wordPattern(String pattern, String str) {
		    char[] patternArray=pattern.toCharArray();
		    String[] strArray=str.split(" ");
		    if(patternArray.length!=strArray.length)
		    	return false;
		    Map mp=new HashMap();
		    for(int i=0;i<patternArray.length;i++){		    	
		    		if(!Objects.equals(mp.putIfAbsent(patternArray[i],i),(mp.putIfAbsent(strArray[i],i))))
		    			//ע��ŵĲ���int����Integer	,С��127ʱ�ӻ���ȡ������ͬһ�����󣬴���127�½�������ͬһ���������Ժ����Ĳ�һ����	    	   
		    		return false;
		    }
	        return true;
	    }
	 public static void main(String[] args){
		 String p="ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
		 String ss="s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
		 /*String p="aba";
		 String ss="dog cat dog";*/
		 Solution s=new Solution();
		 System.out.println(s.wordPattern(p, ss));
	 }
}
