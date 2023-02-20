class Solution {
    public double myPow(double x, int n) {
        long N = n;     //possible overflow in -N, trans to long
        return N >= 0 ? pow(x, N) : pow(1 / x, -N);     
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double temp = pow(x, n / 2);    //save pow in temp instead of call pow twice 
        double res = temp * temp;
        return n % 2 == 1 ? res * x : res;
    }
}