package personal.stock;

//k=2
public class BuyAndSell123 {
    //[3,3,5,0,0,3,1,4]
    public int maxProfit(int[] prices) {
        int[][] dp = new int[3][2];
        dp[2][1]=dp[1][1]=-prices[0];
        dp[2][0]=dp[1][0]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[2][0] = Math.max(dp[2][0], dp[2][1] + prices[i]);
            dp[2][1] = Math.max(dp[2][1], dp[1][0] - prices[i]);

            dp[1][0] = Math.max(dp[1][0], dp[1][1] + prices[i]);
            // k=0时 没有交易次数，dp[i - 1][0][0] = 0
            dp[1][1] = Math.max(dp[1][1], -prices[i]);
        }
        return dp[2][0];
    }
}
