class Solution {
    public int divide(int a, int b) {
        //only condition of result overflow
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        //treatment of signs, negative a, b
        int sign = 1;
        sign = a < 0 ? -sign : sign;
        a = a < 0 ? a : -a;
        sign = b < 0 ? -sign : sign;
        b = b < 0 ? b : -b;        
        //core divide algorithm for two negative numbers
        int dividend = a;
        int divisor = b;
        int res = 0;
        while (dividend <= divisor) {
            int quotient = 1;
            while (divisor >= -1073741824 && divisor + divisor >= dividend) {
                divisor += divisor;
                quotient += quotient;
            }            
            dividend -= divisor;
            res += quotient;       
            divisor = b;    
        }
        return sign == 1 ? res : -res;
    }
}