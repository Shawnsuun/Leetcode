class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        char[] odr = order.toCharArray();
        int[] charToNum = new int[26];
        for (int i = 0; i < 26; i ++) {
            charToNum[odr[i] - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i ++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j ++) {
                if (charToNum[words[i].charAt(j) - 'a'] < charToNum[words[i + 1].charAt(j) - 'a']) {
                    break;
                }
                if (charToNum[words[i].charAt(j) - 'a'] > charToNum[words[i + 1].charAt(j) - 'a']) {
                    return false;
                }
                if (j == words[i + 1].length() - 1 && j < words[i].length() - 1 && 
                    words[i].charAt(j) == words[i + 1].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}