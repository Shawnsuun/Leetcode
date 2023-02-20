class Solution {
    public double soupServings(int n) {
        /** dp(i, j) = probability that soup A will be empty first, 
            plus half the probability that A and B become empty at the same time */
        
        //25ml in 1 serve, less than 25ml is also 1 serve, A, B allocate 4-0, 3-1, 2-2, 3-1
        int serves = (int) Math.ceil((double) n / 25);  
        if (serves >= 179) {    //p ¡Ö 1 if n is larger than 4475
            return 1.0;
        }

        double[][] dp = new double[serves + 1][serves + 1];       
        dp[0][0] = 0.5; //A, B is empty, half the probability that A and B become empty is 0.5
        for (int i = 1; i <= serves; i ++) {
            dp[i][0] = 0;   //B is empty and A is not, the probability is 0
        }        
        for (int j = 1; j <= serves; j ++) {
            dp[0][j] = 1;   //A is empty and B is not, the probability of A is empty first is 1
        }
        
        for (int i = 1; i <= serves; i ++) {
            for (int j = 1; j <= serves; j ++) {
                //remaining soup is not enough, serve as much as possible, use max function here
                dp[i][j] = (dp[Math.max(i - 4, 0)][j] 
                + dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)] 
                + dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] 
                + dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)]) / 4; 
            }            
        }                
        return dp[serves][serves];
    }
}