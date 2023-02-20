class Solution {
    public String addBinary(String a, String b) {
        char[] digitsA = a.toCharArray();
        char[] digitsB = b.toCharArray();
        int lenA = digitsA.length;
        int lenB = digitsB.length;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lenA || i < lenB; i ++) {
            int digitA = i < lenA ? digitsA[lenA - i - 1] - '0' : 0;
            int digitB = i < lenB ? digitsB[lenB - i - 1] - '0' : 0;
            int digit = digitA + digitB + carry >= 2 ? digitA + digitB + carry - 2 : digitA + digitB + carry;           
            carry = digitA + digitB + carry >= 2 ? 1 : 0;
            builder.append(digit);
        }
        if (carry == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }
}