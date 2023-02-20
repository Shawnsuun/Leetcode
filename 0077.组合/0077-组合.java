class Solution {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> subset = new LinkedList<Integer>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        helper(n, k, 1, subset, res);
        return res;
    }

    private void helper(int n, int k, int index, LinkedList<Integer> subset, List<List<Integer>> res) {
        if (subset.size() == k) {
            res.add(new LinkedList<Integer>(subset));
        } else if (index <= n && subset.size() < k) {
            helper(n, k, index + 1, subset, res);

            subset.add(index);
            helper(n, k, index + 1, subset, res);
            subset.removeLast();
        }
    }
}