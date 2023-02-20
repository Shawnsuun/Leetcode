class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i ++) {
            map.put(arr[i], i);
        }

        int[][] dp = new int[len][len];
        int res = 2;
        for (int i = 1; i < len; i ++) {
            for (int j = 0; j < i; j ++) {
                int k = map.getOrDefault(arr[i] - arr[j], -1);
                dp[i][j] = k >= 0 && k < j ? dp[j][k] + 1 : 2;

                res = Math.max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }
}