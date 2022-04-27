package com.datastructure.dynamic;

public class MinimumPathSum {
	public int minPathSum(int[][] grid){
		for(int i=0;i<grid.length;i++)
			for(int j=0;j<grid[0].length;j++){
				if(i>0&&j==0)grid[i][j]+=grid[i-1][j];
				else if(i==0&&j>0)grid[i][j]+=grid[i][j-1];
				else if(i>0&&j>0)grid[i][j]+=Math.min(grid[i-1][j], grid[i][j-1]);
			}
		return grid[grid.length-1][grid[0].length-1];
	}
	public static void main(String[] args){
		MinimumPathSum mps=new MinimumPathSum();
		System.out.println(mps.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
	}
}
