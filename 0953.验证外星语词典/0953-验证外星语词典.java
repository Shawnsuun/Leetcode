class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charToNum = new int[26];
        for (int i = 0; i < 26; i ++) {
            charToNum[order.charAt(i) - 'a'] = i;
        }
        Boolean smallLtr = false;
        for (int i = 0; i < words.length - 1; i ++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j ++) {
                if (charToNum[words[i].charAt(j) - 'a'] > charToNum[words[i + 1].charAt(j) - 'a']) {
                    return false;
                } 
                else if (charToNum[words[i].charAt(j) - 'a'] < charToNum[words[i + 1].charAt(j) - 'a']) {
                    smallLtr = true;
                    break;  
                } 
            }
            if (smallLtr == false && words[i].length() > words[i + 1].length()) {
                return false; 
            }  
        }
        return true;
    }
}