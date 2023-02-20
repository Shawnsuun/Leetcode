class Solution {
    public int cuttingRope(int n) {
        //To get max product: rope cut in equal len, best length is 3, then 2
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int)Math.pow(3, a);
        } else if (b == 1) {
            return (int)Math.pow(3, a - 1) * 2 * 2;
        }
        return (int)Math.pow(3, a) * 2;
    }
}