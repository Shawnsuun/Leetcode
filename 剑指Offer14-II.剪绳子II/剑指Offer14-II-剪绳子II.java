class Solution {
    public int cuttingRope(int n) {
        int MOD = 1000000007;
        if (n <= 3) {
            return n - 1;
        }
        if (n % 3 == 0) {
            return powMod(3, n / 3);
        } else if (n % 3 == 1) {
            return (powMod(3, (n - 4) / 3) % MOD * 2 % MOD * 2) % MOD;
        }
        return (powMod(3, (n - 2) / 3) % MOD * 2) % MOD;
    }

    private int powMod(int a, int b) {
        int MOD = 1000000007;
        long res = 1;
        for (int i = 0; i < b; i ++) {
            res = (res * a) % MOD;
        }
        return (int)res;
    }
}