class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];  //min price in first i days
        int res = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i ++) {
            minVal = Math.min(minVal, prices[i]);
            dp[i] = minVal;
            res = Math.max(prices[i] - dp[i], res);
        }
        return res;
    }
}