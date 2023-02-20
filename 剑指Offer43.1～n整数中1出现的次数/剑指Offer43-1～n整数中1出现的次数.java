class Solution {
    public int countDigitOne(int n) {
        //initial condition, cur in the last digit
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {     //current digit is 0
                res += high * digit;
            } else if (cur == 1) {      //current digit is 1
                res += high * digit + 1 + low;
            } else {
                res += (high + 1) * digit;
            }
            //next digit
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}