class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> permutation = new LinkedList<Integer>();
            for (int num : nums) {
                permutation.add(num);
            }
            res.add(permutation);
        } else {
            //for a fixed i, when nums of index i, j swapped, nums[j] is saved in a set
            Set<Integer> swapedJ = new HashSet<Integer>();
            for (int j = i; j < nums.length; j ++) {
                //skip j if nums[j] has been already swapped
                if (!swapedJ.contains(nums[j])) {
                    swapedJ.add(nums[j]);
                    swap(nums, i, j);
                    helper(nums, i + 1, res);
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}