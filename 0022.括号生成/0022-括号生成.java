class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        String pairs = "";
        helper(n, n, pairs, res);
        return res;
    }

    //left/right is the number of available left/right parentheses
    private void helper(int left, int right, String pairs, List<String> res) {
        //base case
        if (left == 0 && right == 0) {
            res.add(pairs);
        } 
        
        //available left parentheses exist
        if (left > 0) {
            helper(left - 1, right, pairs + '(', res);
        }

        //can add right parenthesis only when left parentheses are more than right parentheses in current string
        //this time available right parentheses are more than available left parentheses
        if (right > left) {
            helper(left, right - 1, pairs + ')', res);
        }
    }
}