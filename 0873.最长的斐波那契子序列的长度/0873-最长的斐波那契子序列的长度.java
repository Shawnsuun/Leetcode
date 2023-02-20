class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        //hashmap save num and index in array
        Map<Integer, Integer> numIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i ++) {
            numIndexMap.put(arr[i], i);
        }
        
        //dp[i][j]: length of fib num subseq which arr[i] as last fib num, arr[j] as 2nd last fib num
        int[][] dp = new int[len][len];
        int res = 2;
        for (int i = 1; i < len; i ++) {
            for (int j = 0; j < i; j ++) {
                int k = numIndexMap.getOrDefault(arr[i] - arr[j], -1);
                dp[i][j] = k != -1 && j > k ? dp[j][k] + 1 : 2;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }
}