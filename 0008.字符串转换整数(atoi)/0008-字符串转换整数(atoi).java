class Solution {
    public int myAtoi(String s) {
        //ignore any leading whitespace
        s = s.strip();
        int sign = 1;
        if (s.length() == 0) return 0;
        if (!Character.isDigit(s.charAt(0))) {
            if (s.charAt(0) == '-') {
                sign = -1;
            } else if (s.charAt(0) != '+') {
                return 0;
            }
            s = s.substring(1);
        }
        char[] digits = s.toCharArray();
        int res = 0;
        int checkPoint = Integer.MAX_VALUE / 10;
        for (char ch : digits) {
            if (Character.isDigit(ch)) {
                int digit = ch - '0';
                if (res > checkPoint || res == checkPoint && digit > 7) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res *= 10;
                res += digit;
            } else {
                break;
            }
        }
        return sign * res;
    }
}