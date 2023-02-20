class Solution {
    public String reverseWords(String s) {
        s = s.strip();
        String[] words = s.split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i --) {
            if (i != words.length - 1) {
                builder.append(" ");
            }            
            builder.append(words[i]);
        }
        return builder.toString();
    }
}