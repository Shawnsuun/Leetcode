class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int num : nums) {
            sum += num;
        }
        boolean[][] dp = new boolean[len + 1][sum + 1];
        dp[0][0] = true;
              
        for (int i = 1; i <= len; i ++) {    //select from first i numbers
            for (int j = i; j >= 1; j --) {  //j numbers are selected
                for (int k = nums[i - 1]; k <= sum; k ++) { //the sum of j numbers is k
                    if (dp[j - 1][k - nums[i - 1]]) {
                        dp[j][k] |= dp[j - 1][k - nums[i - 1]];
                    }              
                }
            }
        }
        for (int i = 1; i < len; i ++) {
            if (sum * i % len == 0 && dp[i][sum * i / len]) {
                return true;
            }
        }
        return false;
    }
}