class Solution {
    public boolean checkPowersOfThree(int n) {
        int num = n;
        while (num > 0) {
            int bit = num % 3;  //each bit of trinary
            if (bit == 2) {
                return false;   //bit can not be 2, or the power is not distinct
            }
            num = num / 3; 
        }
        return true;
    }
}