int countDigitOne(int n){
    long digitPos = 1;
    int curDigit = n % 10;
    int higherDigits = n / 10;
    int lowerDigits = 0;
    int res = 0;
    while (!(higherDigits == 0 && curDigit == 0)) {
        if (curDigit == 0) {
            res += higherDigits * digitPos;
        } else if (curDigit == 1) {
            res += higherDigits * digitPos + lowerDigits + 1;
        } else {
            res += (higherDigits + 1) * digitPos;
        }
        lowerDigits += curDigit * digitPos;
        curDigit = higherDigits % 10;
        higherDigits /= 10;
        digitPos *= 10;
    }
    return res;
}