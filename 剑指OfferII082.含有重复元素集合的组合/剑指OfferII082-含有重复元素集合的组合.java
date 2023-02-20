class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        backtracking(candidates, target, 0, new LinkedList<Integer>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int target, int index, 
        LinkedList<Integer> sub, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new LinkedList<Integer>(sub));
        } else if (target > 0 && index < candidates.length) {
            backtracking(candidates, target, getNext(candidates, index), sub, res);

            sub.add(candidates[index]);
            backtracking(candidates, target - candidates[index], index + 1, sub, res);
            sub.removeLast();
        }
    }

    private int getNext(int[] sorted, int index) {
        int len = sorted.length;
        for (int i = index; i < len; i ++) {
            if (sorted[i] > sorted[index]) {
                return i;
            }
        }
        return len;
    }
}