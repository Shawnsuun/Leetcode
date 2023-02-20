class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        backtracking(nums, 0, res);
        return res;
    }

    private void backtracking(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> p = new LinkedList<Integer>();
            for (int num : nums) {
                p.add(num);
            }
            res.add(p);
        } else if (index < nums.length) {
            for (int i = index; i < nums.length; i ++) {
                swap(nums, index, i);
                backtracking(nums, index + 1, res);
                swap(nums, i, index);
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