class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i ++) {
            //lower = num[j], nums[i] - nums[j] > 0
            Integer lower = set.floor(nums[i]);
            if (lower != null && lower >= nums[i] - valueDiff) {
                return true;
            }
            //upper = num[j], nums[i] - nums[j] < 0
            Integer upper = set.ceiling(nums[i]);
            if (upper != null && upper <= nums[i] + valueDiff) {
                return true;
            }
            //add num[i] into set
            set.add(nums[i]);
            //limit set length < indexDiff - 1
            if (i > indexDiff - 1) {
                set.remove(nums[i - indexDiff]);
            }    
        }
        return false;
    }
}