class Solution {
    public int numDifferentIntegers(String word) {
        int MOD = 1000000007;
        char[] chars = word.toCharArray();
        int len = chars.length;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < len) {
            if (Character.isDigit(chars[i]) ) {
                int num = 0;
                while (i < len && Character.isDigit(chars[i])) {
                    num = (num * 10 + (chars[i] - '0')) % MOD;
                    i ++;
                }
                set.add(num);
            } else {
                i ++;
            }
        }
        return set.size();
    }
}