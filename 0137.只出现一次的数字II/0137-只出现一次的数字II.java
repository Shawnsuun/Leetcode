class Solution {
    public int singleNumber(int[] nums) {
        int[] bitsum = new int[32];
        for (int num : nums) {
            //loop 32 digits in binary, if it is 1, bitsum[i] add 1.
            for (int i = 0; i < 32; i++) {
                bitsum[i] += num >> (31 - i) & 1;
            }
        }
        int res = 0;
        
        //loop 32 elements in bitsum, if an element % 3 is 1, single number's is 1 in that location.
        for (int i = 0; i < 32; i++) {
            //loop to make res binary move left 1 digit, and add single number's 32 digits.
            res = (res << 1) + bitsum[i] % 3;
        }
        return res;
    }
}