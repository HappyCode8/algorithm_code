package personal.stock;

//可以交易k次
public class BuyAndSell188 {
    public int maxProfit(int[] prices, int k) {
        //[第几天][还可以交易k次][不持有0，持有1]，dp代表当前能获得的最大利润
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = 0;//第一天不持有
            dp[0][j][1] = -prices[0];//第一天持有
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                //不持有股票要么是前一天就不持有，要么是前一天持有今天卖掉
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                //持有股票要么是前一天就不持有，要么是前一天不持有今天买了，买的时候要把次数扣减
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        int ans = 0;
        for (int j = 0; j <= k; j++) {
            ans = Math.max(ans, dp[prices.length - 1][j][0]);
        }
        return ans;
    }
}
