class Solution {
    public int minOperations(String s) { 
        char[] digits = s.toCharArray();
        int len = digits.length;
        int res = 0;
        for (int i = 0; i < len; i ++ ) {
            res += digits[i] ^ '0' ^ (i & 1);   //get flip times when transfer to 01010101...
        }
        return Math.min(res, len - res);
    }
}