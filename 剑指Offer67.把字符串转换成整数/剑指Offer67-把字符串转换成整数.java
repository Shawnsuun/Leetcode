class Solution {
    public int strToInt(String str) {
        //treatment of sign '+', '-'
        int neg = 1;
        str = str.strip();
        int startIndex = 0;
        if (str.startsWith("+") || str.startsWith("-")) {
            startIndex ++;
            if (str.startsWith("-")) {
                neg = -1;
            }
        }
        //calculation process
        int res = 0;
        int boundary = Integer.MAX_VALUE / 10;  //check boundary before the possible step to int max value
        char[] chars = str.toCharArray();
        for (int i = startIndex; i < chars.length; i ++) {
            if (Character.isDigit(chars[i])) {
                //if res == boundary && chars[i] == '7', will return Integer.MAX_VALUE in the next loop
                if (res > boundary || (res == boundary && chars[i] > '7')) {    
                    return neg == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = 10 * res + (chars[i] - '0');
            } else {
                break;
            }
        }
        return res * neg;
    }
}