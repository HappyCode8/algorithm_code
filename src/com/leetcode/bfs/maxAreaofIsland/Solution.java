package com.leetcode.bfs.maxAreaofIsland;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int maxAreaOfIsland(int[][] grid) {
		int res = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1){
					res = Math.max(res, bfs(grid, i, j));
				}
			}
		}
		return res;
	}

	//每次把一个为1的点加入到队列然后弹出时把周围为1的加入，直到这个队列为空
	public int bfs(int[][] grid, int i, int j){
		int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{i, j});
		grid[i][j] = 0;
		int area = 1;
		while(!queue.isEmpty()){
			int[] x = queue.poll();
			for(int index = 0; index < direction.length; index++){
				int nx = x[0] + direction[index][0];
				int ny = x[1] + direction[index][1];
				if(nx>=0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1){
					grid[nx][ny] = 0;
					area += 1;
					queue.offer(new int[]{nx, ny});
				}
			}
		}
		return area;
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
