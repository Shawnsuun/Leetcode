class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //empty int[] nums
        if (nums.length == 0) {
            return null;
        }
        //initialize result set and subset
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> subset = new LinkedList<Integer>();

        helper(nums, 0, subset, res);
        return res;
    }

    private void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> res) {
        //end of int[] num, all nums are treated, add subset to res
        if (index == nums.length) {
            //add a copy of subset in res
            //has to be a copy, or subset in res will change since it's a pointer
            res.add(new LinkedList<Integer>(subset));
        } else {
            //skip num, to the next num in nums
            helper(nums, index + 1, subset, res);
            
            //add num to the subset
            subset.add(nums[index]);
            helper(nums, index + 1, subset, res);
            //back to its parent
            subset.removeLast();
        }
    }
}