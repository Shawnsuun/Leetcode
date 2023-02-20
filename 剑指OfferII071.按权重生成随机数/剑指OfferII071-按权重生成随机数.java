class Solution {
    private int[] sums;
    private int total;

    public Solution(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < w.length; i ++) {
            total += w[i];
            sums[i] = total;
        }
    }
    
    public int pickIndex() {
        int ran = new Random().nextInt(total);
        int left = 0;
        int right = sums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sums[mid] == ran) {
                return mid + 1;
            } else if (sums[mid] > ran) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */