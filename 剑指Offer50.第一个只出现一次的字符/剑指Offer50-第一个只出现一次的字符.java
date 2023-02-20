class Solution {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < chars.length; i ++) {
            count[chars[i] - 'a'] += 1;
        }
        for (int i = 0; i < chars.length; i ++) {
            if (count[chars[i] - 'a'] == 1) {
                return chars[i];
            }
        }
        return ' ';
    }
}