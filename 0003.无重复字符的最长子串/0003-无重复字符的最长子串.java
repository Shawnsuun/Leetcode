class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[256];
        int max_len = 0;
        int left = 0;
        int dupcnt = 0;

        for (int right = 0; right < s.length(); right ++) {            
            counts[s.charAt(right)] += 1; 
            if (counts[s.charAt(right)] == 2) {
                dupcnt += 1;
            }            
            while (dupcnt != 0) {
                counts[s.charAt(left)] -= 1;
                if (counts[s.charAt(left)] == 1) {
                    dupcnt -= 1;
                }                   
                left += 1;
            }
            max_len = Math.max(max_len, right - left + 1);
        }
        return max_len;
    }

}