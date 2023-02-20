class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int len = nums.length;
        int minSuff = nums[len - 1];
        for (int i = len - 3; i >= 0; i --) {   
            if (minSuff < nums[i]) {
                return false;   //when local inversion is not the only global inversion, return false
            }
            minSuff = Math.min(minSuff, nums[i + 1]);
        }
        return true;
    }
}