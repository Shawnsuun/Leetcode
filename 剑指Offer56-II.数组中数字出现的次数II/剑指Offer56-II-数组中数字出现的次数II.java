class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i ++) {
                bits[i] += (num >> (31 - i)) & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i ++) {
            if (bits[i] % 3 != 0) {
                res += 1 << (31 - i);
            }
        }
        return res;
    }
}