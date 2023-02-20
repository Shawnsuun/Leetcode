class Solution {
    public int translateNum(int num) {
        String number = ((Integer)num).toString();
        int[] digits = new int[number.length()];
        for (int i = 0; i < digits.length; i ++) {
            digits[i] = number.charAt(i) - '0';
        }
        int[] dp = new int[digits.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= digits.length; i ++) {
            dp[i] += dp[i - 1];
            if (digits[i - 2] == 1 || (digits[i - 2] == 2 && digits[i - 1] <= 5)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[digits.length];
    }
}