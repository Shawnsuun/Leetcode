class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int len = nums.length;
        int k = 2;
        while (k < len) {
            //k skip to the last index of same numbers
            while (k < len - 1 && nums[k] == nums[k + 1]) {
                k ++;
            }
            twoSum(nums, k, res);
            k ++;                       
        }
        return res;
    }

    private void twoSum(int[] nums, int k, List<List<Integer>> res) {
        int i = 0;
        int j = k - 1;
        while (i < j) {
            if (nums[i] + nums[j] > -nums[k]) {
                j --;
            } else if (nums[i] + nums[j] < -nums[k]) {
                i ++;
            } else {
                List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                res.add(list);
                int temp = nums[i];
                //after nums[i] is used, i skip a different number
                while (i < j && nums[i] == temp) {
                    i ++;
                }
            }    
        }        
    }

}