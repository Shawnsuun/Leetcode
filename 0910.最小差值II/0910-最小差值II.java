class Solution {
    public int smallestRangeII(int[] nums, int k) {
        //Sort the array
        Arrays.sort(nums);
        //Initial condition
        int end = nums[nums.length - 1];
        int head = nums[0];
        int ans = end - head;
        //If k >= ans, the ans is end - head
        if (k >= ans) {
            return ans;
        }
        //Scan each pair of the joint nodes
        for (int i = 0; i < nums.length - 1; i ++) {
            //nums index 0 ~ i rise, get highest point
            int high = Math.max(nums[i] + k, end - k);
            //nums index i + 1 ~ nums.length - 1 drop, get lowest point
            int low = Math.min(nums[i + 1] - k, head + k);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }
}