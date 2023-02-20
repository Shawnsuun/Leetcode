class Solution {
    public int secondHighest(String s) {
        boolean[] digits = new boolean[10];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch - '0' < 10) {
                digits[ch - '0'] = true;
            }
        }
        boolean findFirst = false;
        for (int i = 9; i >= 0; i --) {
            if (digits[i] && findFirst == false) {
                findFirst = true;
            } else if (digits[i] && findFirst == true) {
                return i;
            }
        }
        return -1;
    }
}