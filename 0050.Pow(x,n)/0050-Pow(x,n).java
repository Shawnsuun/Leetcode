class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return myPow(1 / x, Integer.MAX_VALUE) / x;
            }
            return myPow(1 / x, -n);
        }
        double temp = myPow(x, n >> 1);
        if ((n & 1) == 1) {
            return temp * temp * x;
        }
        return temp * temp;
    }
}