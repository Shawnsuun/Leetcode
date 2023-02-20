class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //left & right represent index of pairs, leave the last num alone
        int left = 0;
        int right = nums.length / 2 - 1;
        while (left <= right) {
            int middle = (left + right) / 2; 
            if (nums[middle * 2] != nums[middle * 2 + 1]) {
                right = middle - 1;
            } else if (nums[middle * 2] == nums[middle * 2 + 1]) {
                left = middle + 1;
            }
        }
        return nums[left * 2];
    }
}