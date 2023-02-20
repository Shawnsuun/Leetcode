class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;
        int reverse = 0;
        for (int i = 0; i < len; i ++) {
            if (nums[i] > nums[(i + 1) % len]) {
                reverse ++;
            }
        }
        return reverse <= 1;
    }
}