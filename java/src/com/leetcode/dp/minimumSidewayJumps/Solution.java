package com.leetcode.dp.minimumSidewayJumps;

public class Solution {
    public int minSideJumps(int[] obstacles) {
        int length = obstacles.length;
        int[][] dp = new int[3][length];
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[2][0] = 1;
        for (int colIndex = 1; colIndex < length; colIndex++) {
            for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
                if (rowIndex + 1 == obstacles[colIndex]) {
                    dp[rowIndex][colIndex] = -1;
                    continue;
                }
                if (dp[rowIndex][colIndex - 1] != -1) {
                    dp[rowIndex][colIndex] = dp[rowIndex][colIndex - 1];
                }
            }
            for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
                if (rowIndex == 0 && dp[rowIndex][colIndex - 1] == -1 && dp[rowIndex][colIndex] != -1) {
                    dp[rowIndex][colIndex] = min(dp[1][colIndex], dp[2][colIndex]) + 1;
                }
                if (rowIndex == 1 && dp[rowIndex][colIndex - 1] == -1 && dp[rowIndex][colIndex] != -1) {
                    dp[rowIndex][colIndex] = min(dp[0][colIndex], dp[2][colIndex]) + 1;
                }
                if (rowIndex == 2 && dp[rowIndex][colIndex - 1] == -1 && dp[rowIndex][colIndex] != -1) {
                    dp[rowIndex][colIndex] = min(dp[0][colIndex], dp[1][colIndex]) + 1;
                }
            }
        }
        //加上下边这部分代码提交会超时
        /*for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/
        return Math.min(Math.min(dp[0][length - 1], dp[1][length - 1]), dp[2][length - 1]);
    }

    private int min(int num1, int num2) {
        if (num1 == -1) {
            return num2;
        }
        if (num2 == -1) {
            return num1;
        }
        return Math.min(num1, num2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] obstacles = new int[]{};
        System.out.println(s.minSideJumps(obstacles));
    }
}
