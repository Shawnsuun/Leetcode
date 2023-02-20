class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        int[] nums = new int[words.length];
        int k = 0;
        for (String word : words) {
            int num = 0;
            char[] chars = word.toCharArray();
            for (char ch : chars) {
                num |= (1 << (ch - 'a'));
            }
            nums[k] = num;
            k ++;
        }
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if ((nums[i] & nums[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}