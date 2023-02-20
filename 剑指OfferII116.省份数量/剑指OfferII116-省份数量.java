class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i ++) {
            parents[i] = i;
        }
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) {
                if (isConnected[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i ++) {
            if (parents[i] == i) {
                res ++;
            }
        }
        return res;
    }

    private int findRoot(int[] parents, int i) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return parents[i];
    }

    private void union(int[] parents, int i, int j) {
        int rootI = findRoot(parents, i);
        int rootJ = findRoot(parents, j);
        if (rootI != rootJ) {
            parents[rootJ] = rootI; 
        }
    }
}