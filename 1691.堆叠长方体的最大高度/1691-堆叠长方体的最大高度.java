class Solution {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        //to put on top L + W + H have to be smaller, not vise versa
        Arrays.sort(cuboids, (x, y) -> x[0] + x[1] + x[2] - y[0] - y[1] - y[2]);
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i ++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j ++) {
                if (cuboids[i][0] >= cuboids[j][0] &&   //filter eligible cubes
                    cuboids[i][1] >= cuboids[j][1] &&
                    cuboids[i][2] >= cuboids[j][2]) {
                        dp[i] = Math.max(dp[i], cuboids[i][2] + dp[j]); //dp[i] may change, use cuboids[i][2]
                    }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}