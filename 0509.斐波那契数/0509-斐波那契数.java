class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] temp = new int[]{0, 1};
        int res = 0;
        for (int i = 2; i <= n; i ++) {
            res = temp[0] + temp[1];
            temp[i % 2] = res;
        }
        return res;
    }
}