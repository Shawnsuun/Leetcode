class Solution {
    public int lastRemaining(int n, int m) {
        //f(n, m) = 0                          n = 1
        //f(n, m) = (f(n - 1, m) + m) % n      n > 1
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }
}