class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int MOD = 1000000007;
        int len = nums.length;
        
        long[] twoExp = new long[len];
        long k = 1;
        for (int i = 0; i < len; i ++) {
            twoExp[i] = k;
            k *= 2;
            k %= MOD;
        }
        
        long res = 0;
        for (int i = 0; i < len; i ++) {
            res += nums[i] * (twoExp[i] - twoExp[len - i - 1]);
            res %= MOD;
        }
        return (int) res;
    }
}