class Solution {
    public int findRepeatNumber(int[] nums) {      
        for (int i = 0; i < nums.length; i ++) {
            while (nums[i] != i) {
                //nums[i] != i, nums[i] need to swap with nums[nums[i]]
                if (nums[i] == nums[nums[i]]) { //nums[i] and nums[nums[i]] are the same
                    return nums[i]; //find duplicate num
                }

                //swap until nums[i] = i
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            } 
        }
        return -1;
    }
}