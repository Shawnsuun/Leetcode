class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        helper(nums, 0, res);
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res) {
        //if i reach end of nums, add the permutation to the result
        if (i == nums.length) {
            List<Integer> p = new LinkedList<Integer>();
            for (int num : nums) {
                p.add(num);
            }
            res.add(p);
        } else {
            //fixed i, loop all possible j, swap
            for (int j = i; j < nums.length; j ++) {
                //swap index i, j in nums
                swap(nums, i, j);
                //the next i for recursion
                helper(nums, i + 1, res);
                //swap back
                swap(nums, i, j);
            }
        }
    }

    //swap two indexs in a num array
    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}