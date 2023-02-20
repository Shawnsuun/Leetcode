public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 1; i <= 32; i ++) {
            res += (n >> (32 - i)) & 1;
        }
        return res;
    }
}