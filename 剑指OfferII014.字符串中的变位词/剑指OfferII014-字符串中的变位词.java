class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //exclude based on length
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        //initialze target and window letter count arrays
        int[] target = new int[26];
        int[] window = new int[26];
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < len1; i ++) {
            target[chars1[i] - 'a'] ++;
            window[chars2[i] - 'a'] ++;
        }
        if (Arrays.equals(window, target)) {
            return true;
        }
        //sliding window until window equals target array
        for (int i = 0; i < len2 - len1; i ++) {
            window[chars2[i] - 'a'] --;
            window[chars2[i + len1] - 'a'] ++;
            if (Arrays.equals(window, target)) {
                return true;
            }            
        }
        return false;
    }
}