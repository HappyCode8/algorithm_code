package personal.stock;

//扣手续费，无限次交易
public class BuyAndSell714 {
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = 0;//不持有
        dp[1] = -prices[0];//持有
        for (int i = 1; i < prices.length; i++) {
            //当前不持有，要么是前一天不持有，要么是前一天持有今天卖了
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            ////当前持有，要么是前一天持有，要么是前一天不持有今天买了
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }
}
