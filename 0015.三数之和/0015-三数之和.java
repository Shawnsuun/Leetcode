class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums.length >= 3) {
            //sort the array
            Arrays.sort(nums);
            int i = 0;
            while (i < nums.length - 2) {
                twoSum(i, nums, res);
                //skip the same i value, different triplets in ans cannot have same i
                int temp = nums[i];
                while (nums[i] == temp && i < nums.length - 2) {
                    i ++;
                }
            }
        } 
        return res;
    }
        private void twoSum(int i, int[]nums, List<List<Integer>>res) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //skip the same j value
                    int temp = nums[j];
                    while (nums[j] == temp && j < k) {
                        j ++;
                    }
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k --;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j ++;
                }
            }   
        }     
}