class Solution {
    public int maxProduct(String[] words) {
        int[] flags = new int[words.length];
        for (int i = 0; i < words.length; i ++) {
            for (char ch : words[i].toCharArray()) {
                /**this is to make word in to a 26-digit binary, 0 | 1 = 1, 1 | 1 = 1;
                ch - 'a' means change char into int */
                flags[i] = flags[i] | 1 << (ch - 'a');
            }
        } 
        //normal way to calculate max production.
        int res = 0;
        for (int i = 0; i < words.length; i ++) {
            for (int j = i + 1; j < words.length; j ++) {
                if ((flags[i] & flags[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        } 
        return res;
    }
}