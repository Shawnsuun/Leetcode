class Solution {
    public int findNthDigit(int n) {
        //number of groups: 1 ~ 9, 10 ~ 99, 100 ~ 999...
        int digit = 1;  //digit for the group, 1, 2, 3...
        long start = 1;  //start number of the group, 1, 10, 100...
        long count = 9;  //group digits size, 9, 180, 2700...
        while (n > count) {
            n -= count;
            start *= 10;
            digit ++;
            count = start * 9 * digit;
        }
        long num = start + (n - 1) / digit;  //locate the number that nth digit in
        return Long.toString(num).charAt((n - 1) % digit) - '0';     //get digit from the number
    }
}