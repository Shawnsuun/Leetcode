class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtracking(nums, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void backtracking(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new LinkedList<Integer>(subset));
        } else if (index < nums.length) {
            backtracking(nums, index + 1, subset, res);
            
            subset.add(nums[index]);
            backtracking(nums, index + 1, subset, res);
            subset.removeLast();
        }
    }
}