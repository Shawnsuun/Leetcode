class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        backtracking(n, k, 1, new LinkedList<Integer>(), res);
        return res;
    }

    private void backtracking(int n, int k, int index, LinkedList<Integer> subset, List<List<Integer>> res) {
        if (subset.size() == k) {
            res.add(new LinkedList<Integer>(subset));
        } else if (index <= n) {
            backtracking(n, k, index + 1, subset, res);

            subset.add(index);
            backtracking(n, k, index + 1, subset, res);
            subset.removeLast();
        }
    }
}