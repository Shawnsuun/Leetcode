class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        //array to save min cost to climb up from each step
        int[] dp = new int[] {cost[0], cost[1]};

        //iteration to get min cost of each step before the final step 
        for (int i = 2; i < len; i ++) {
            dp[i % 2] = Math.min(dp[0], dp[1]) + cost[i];
        }
        //compare to get min cost of final step
        return Math.min(dp[0], dp[1]);
    }
}