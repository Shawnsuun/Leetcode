class Solution {
    public int divide(int dividend, int divisor) {
        int ans = 0;
        int k = 1;
        
        // Note 1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        } 

        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            k = -1;
        } 

        if (dividend > 0) {
            dividend = - dividend;
        } 
        
        if (divisor > 0) {
            divisor = - divisor;
        }
        // Note 2
        while (dividend <= divisor) {
            int pace = 1;
            int multidivisor = divisor;
            //Note 3
            while (multidivisor >= - Math.pow(-2, 30) && dividend <= multidivisor + multidivisor) {
                multidivisor += multidivisor;
                pace += pace;
            }
            ans += pace;
            dividend -= multidivisor;
        }
        if (k < 0) {
            return - ans;
        } 
        return ans;
    }
}