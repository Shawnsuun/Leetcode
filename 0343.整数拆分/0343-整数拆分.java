class Solution {
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        int mod = n % 3;
        int seg = n / 3;
        if (mod == 1) {
            return 2 * 2 * (int)Math.pow(3, seg - 1);
        } else if (mod == 2) {
            return 2 * (int)Math.pow(3, seg);
        }
        return (int)Math.pow(3, seg);
    }
}