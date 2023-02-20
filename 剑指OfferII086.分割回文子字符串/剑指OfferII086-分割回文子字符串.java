class Solution {
    public  String[][] partition(String s) {
        List<String[]> res = new LinkedList<>();
        LinkedList<String> plan = new LinkedList<>();
        backtracking(s, 0, plan, res);
        return res.toArray(new String[res.size()][]);
    }

    private void backtracking(String s, int start, LinkedList<String> plan, List<String[]> res) {
        if (start == s.length()) {
            String[] strs = new String[plan.size()];
            for (int i = 0; i < plan.size(); i ++) {
                strs[i] = plan.get(i);
            }
            res.add(strs);
        } else if (start < s.length()) {
            for (int i = start; i < s.length(); i ++) {
                if (isPalindrome(s.substring(start, i + 1))) {
                    plan.addLast(s.substring(start, i + 1));
                    backtracking(s, i + 1, plan, res);
                    plan.removeLast();
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}