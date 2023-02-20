class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] letters = new int[128];
        char[] chars = s.toCharArray();
        int res = 0;
        int len = 0;
        int left = 0;
        for (int right = 0; right < chars.length; right ++) {
            len ++;
            letters[chars[right]] ++;
            while (left <= right && letters[chars[right]] > 1) {
                len --;
                letters[chars[left]] --;
                left ++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}