package personal.stock;

//交易次数1
public class BuyAndSell121 {
    //k固定是1，删去一维，i天只与i-1天有关，删去一维
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[0] = 0;//第一天不持有时持有的利润
        dp[1] = -prices[0];//第一天持有时持有的利润
        for (int i = 1; i < prices.length; i++) {
            //当前不持有，要么是前一天不持有，要么是前一天持有今天卖了
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            //当前持有，要么是前一天持有，要么是前一天不持有今天买了，这里之所以用-prices[i]是因为k=0时没有交易次数
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }
}
