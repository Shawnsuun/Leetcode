class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 31; i >= 0; i --) {
                bits[i] += (num >> (31 - i)) & 1;
            }
        }
        int res = 0;
        for (int bit : bits) {
            res = (res << 1) + (bit % 3);
        }
        return res;
    }
}