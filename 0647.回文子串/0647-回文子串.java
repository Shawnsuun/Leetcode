class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        } 
        return count;
    }

    private int countPalindrome(String s, int front, int end) {
        int addcount = 0;
        while (front >= 0 && end < s.length() && s.charAt(front) == s.charAt(end)) {
            addcount ++;
            front --;
            end ++;
        }
        return addcount;
    }

}