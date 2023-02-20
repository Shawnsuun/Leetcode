class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int res = (int) Math.exp(0.5 * Math.log(x));
        return (long) (res + 1) * (res + 1) <= x ? res + 1 : res;
    }
}