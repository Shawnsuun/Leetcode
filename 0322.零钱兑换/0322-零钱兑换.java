class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp function : f(i) = min(f(i - coins[j]) + 1), i is the target amount
        int types = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;  //0 coin is needed to reach target 0

        for (int i = 1; i <= amount; i ++) {
            dp[i] = amount + 1; //initalize the amount cannot be reached
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);  //try different coins, get min
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount]; 
    }
}