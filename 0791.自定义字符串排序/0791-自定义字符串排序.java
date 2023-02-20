class Solution {
    public String customSortString(String order, String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            counts[s.charAt(i) - 'a'] += 1;
        }
        char[] chars = order.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char ch : chars) {
            while (counts[ch - 'a'] > 0) {
                builder.append(ch);
                counts[ch - 'a'] --;
            }
        }
        for (int i = 0; i < 26; i ++) {
            while (counts[i] > 0) {
                builder.append((char)('a' + i));
                counts[i] --;
            }
        }
        return builder.toString();
    }
}