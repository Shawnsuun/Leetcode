class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backtracking(n, n, new StringBuilder(), res);
        return res;
    }

    private void backtracking(int left, int right, StringBuilder builder , List<String> res) {
        if (left == 0 && right == 0) {
            res.add(builder.toString());
            return;
        }
        if (left > 0) {
            builder.append('(');
            backtracking(left - 1, right, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (left < right) {
            builder.append(')');
            backtracking(left, right - 1, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}