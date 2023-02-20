class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> subset = new LinkedList<Integer>();
        helper(candidates, target, 0, subset, res);
        return res;
    }

    private void helper(int[] nums, int tar, int index, LinkedList<Integer> subset, List<List<Integer>> res) {
        if (tar == 0) {
            res.add(new LinkedList<Integer>(subset));
        } else if (index < nums.length && tar > 0) {
            //skip num[index]
            helper(nums, tar, index + 1, subset, res);

            //add num[index], remain num[index]
            subset.add(nums[index]);
            helper(nums, tar - nums[index], index, subset, res);
            subset.removeLast();
        }
    }
}