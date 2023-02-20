class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        backtracking(candidates, target, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int target, int index, 
        LinkedList<Integer> subset, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<Integer>(subset));
        } else if (index < candidates.length && target > 0) {
            backtracking(candidates, target, index + 1, subset, res);

            subset.add(candidates[index]);
            backtracking(candidates, target - candidates[index], index, subset, res);
            subset.removeLast();
        }
    }
}