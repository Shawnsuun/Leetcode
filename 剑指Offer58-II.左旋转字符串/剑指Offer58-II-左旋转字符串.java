class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length(); i ++) {
            builder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i ++) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }
}