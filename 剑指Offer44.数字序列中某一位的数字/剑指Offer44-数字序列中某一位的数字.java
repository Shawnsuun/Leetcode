class Solution {
    public int findNthDigit(int n) {
        int digits = 1;     //number of digits
        long start = 1;     //start: 1, 10, 100...
        long count = 9;
        while (count < n) {
            n -= count;
            digits ++;
            start *= 10;
            count = digits * start * 9;     //count: 9, 180, 2700...
        }
        long num = start + (n - 1) / digits;
        return Long.toString(num).charAt((n - 1) % digits) - '0';
    }
}