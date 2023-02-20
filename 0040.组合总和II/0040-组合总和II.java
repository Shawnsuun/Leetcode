class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<Integer> subset = new LinkedList<Integer>();
        //sort for excluding repetitive
        Arrays.sort(candidates);
        helper(candidates, target, 0, subset, res);
        return res;
    }

    private void helper(int[] can, int tar, int index, LinkedList<Integer> subset, List<List<Integer>> res) {
        if (tar == 0 && !res.contains(new LinkedList(subset))) {
            res.add(new LinkedList(subset));
        } else if (index < can.length && tar > 0) {
            //to avoid repetitive set, if skip a number, skip to the next different one
            int nextDiff = index;
            while (nextDiff < can.length && can[index] == can[nextDiff]) {
                nextDiff += 1;
            }
            helper(can, tar, nextDiff, subset, res);

            subset.add(can[index]);
            helper(can, tar - can[index], index + 1, subset, res);
            subset.removeLast();
        }
    }
}