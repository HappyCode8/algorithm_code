package com.leetcode.dp.stock;

//含有冷冻期,无限制交易次数
//https://www.cnblogs.com/zle1992/p/16549042.html
public class BuyAndSell309 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;//第一天不持有
        dp[0][1] = -prices[0];//第一天持有

        dp[1][0] = Math.max(dp[0][0], prices[1] + dp[0][1]);//第二天不持有
        dp[1][1] = Math.max(-prices[1], dp[0][1]);//第二天持有

        for (int i = 2; i < prices.length; i++) {
            // 当前不持有，要么是前一天不持有，要么是前一天持有今天卖了
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            //今天持有，要么是昨天不持有，要么是前天不持有今天买了，注意在此
            dp[i][1] = Math.max(dp[i - 2][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}
