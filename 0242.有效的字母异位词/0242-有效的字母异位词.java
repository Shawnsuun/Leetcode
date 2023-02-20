class Solution {
    public boolean isAnagram(String s, String t) {
        int[] charArray = new int[26];
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }
        for (char ch : s.toCharArray()) {
            charArray[ch - 'a'] ++;
        }
        for (char ch : t.toCharArray()) {
            if (charArray[ch - 'a'] == 0) {
                return false;
            }
            charArray[ch - 'a'] --;
        }
        return true;
    }
}