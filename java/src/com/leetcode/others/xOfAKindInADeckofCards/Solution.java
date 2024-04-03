package com.leetcode.others.xOfAKindInADeckofCards;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public boolean hasGroupsSizeX(int[] deck) {
		Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<deck.length;i++){
        	map.put(deck[i], map.getOrDefault(deck[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> e:map.entrySet()){
        	System.out.print(e.getKey()+" ");
        	System.out.println(e.getValue());
        }
        
        for(int x=2;x<=deck.length;x++){
        	int k=0;
        	if(deck.length%x==0)
        		for(int key:map.keySet())
        			if(map.get(key)%x!=0)
        				break;
        			else
						k++;
			if(k==map.keySet().size())
				return true;
        }
		return false;
    }
	public static void main(String[] args){
		Solution s=new Solution();
		int[] d={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		          0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		          0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		          0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		          0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		          0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		          0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		          0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
		          0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
		          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
		          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
		          1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,
		          2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,
		          3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
		          3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
		          3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
		          3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,
		          3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4,
		          4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4
		          ,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,
		          4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,
		          4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,
		          5,5,5,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,
		          6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,
		          6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,7,
		          7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,
		          8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9,9,9,9,
		          9,9,9,10,10,10,10,10,10,10,10,10,10,11,11,11,11,11,12,12,12,12,12};
		System.out.print(s.hasGroupsSizeX(d));
	}	
}