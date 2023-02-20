class Solution {
    public int minOperations(int[] nums) {
        int opt = 0;
        int len = nums.length;
        if (len == 1) {
            return opt;
        }
        for (int i = 1; i < len; i ++) {
            if (nums[i] <= nums[i - 1]) {
                int curOpt = nums[i - 1] - nums[i] + 1;
                opt += curOpt;
                nums[i] += curOpt;
            }
        }
        return opt;
    }
}