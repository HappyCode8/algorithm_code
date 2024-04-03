package com.leetcode.dfs.maxAreaofIsland;

public class Solution {
public int maxAreaOfIsland(int[][] grid) {
	    int maxArea=0;
        for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]==1) {
					maxArea=Math.max(maxArea, dfs(grid,i,j));
				}
			}
		}
        return maxArea;
  }
public int dfs(int[][] grid,int i,int j){
	if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]==1){
		//这里搜过的都赋值为0就行，下次也不需要重新搜了
		grid[i][j]=0;
		return 1+dfs(grid,i+1,j)+dfs(grid,i-1,j)+dfs(grid,i,j+1)+dfs(grid,i,j-1);
    }
	return 0;
}
public static void main(String[] args){
	Solution s=new Solution();
	int[][] a={{0,0,1,0,0,0,0,1,0,0,0,0,0},
			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			 {0,1,1,0,1,0,0,0,0,0,0,0,0},
			 {0,1,0,0,1,1,0,0,1,0,1,0,0},
			 {0,1,0,0,1,1,0,0,1,1,1,0,0},
			 {0,0,0,0,0,0,0,0,0,0,1,0,0},
			 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
	System.out.println(s.maxAreaOfIsland(a));
	for (int[] row : a) {
		for (int column : row) {
			System.out.print(column);
		}
		System.out.println();
	}
}
}
