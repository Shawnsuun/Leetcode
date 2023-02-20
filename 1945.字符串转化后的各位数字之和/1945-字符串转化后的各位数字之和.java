class Solution {
    public int getLucky(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch : chars) {
            builder.append(String.valueOf((ch - 'a' + 1)));
        }
        String converted = builder.toString();
        int res = 0;
        for (int i = 0; i < k; i ++) {
            chars = converted.toCharArray();
            res = 0;
            for (char ch : chars) {
                res += ch - '0';
            }
            converted = String.valueOf(res);
        }
        return res;
    }
}