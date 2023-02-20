class Solution {
    public List<List<String>> partition(String s) {
        LinkedList<String> partition = new LinkedList<String>();
        List<List<String>> res = new LinkedList<List<String>>();
        backtracking(s, 0, partition, res);
        return res;
    }

    private void backtracking(String s, int start, LinkedList<String> partition, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new LinkedList<String>(partition));
            return;
        } 
        
        //substring begins with start, loop to get various substrings with different end
        for (int end = start; end < s.length(); end ++) {
            if (isPalindrome(s, start, end)) {
                partition.add(s.substring(start, end + 1));
                //get the next substring begins from end + 1 recursively
                backtracking(s, end + 1,  partition, res);
                partition.removeLast();
            }
        }
    }

    //check if a substring of str from index start to end is panlindrome
    private boolean isPalindrome(String str,int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}