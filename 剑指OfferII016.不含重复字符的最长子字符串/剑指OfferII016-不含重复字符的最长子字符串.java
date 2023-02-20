class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == "") return 0;
        int[] flags = new int[128];
        char[] chars = s.toCharArray();
        int res = 0, dup = 0, left = 0;
        for (int right = 0; right < s.length(); right ++) {
            flags[chars[right]] ++;
            if (flags[chars[right]] ==2) {
                dup ++;
            }
            if (dup == 0) {
                res = Math.max(res, right - left + 1);
            } else {
                while (left < right && dup > 0) {
                    flags[chars[left]] --;
                    if (flags[chars[left]] == 1) {
                        dup --;
                    }
                    left ++;
                }
            }
        }
        return res;
    }
}