class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i ++) {
            parent[i] = -1;
        }
        for (int[] edge : edges) {
            if (!isConnected(parent, edge[0], edge[1])) {
                parent[findRoot(parent, edge[1])] = findRoot(parent, edge[0]);
            }
        }
        return isConnected(parent, source, destination);
    }

    private int findRoot(int[] parent, int n) {
        while (parent[n] >= 0) {
            n = parent[n];
        }
        return n;
    }

    private boolean isConnected(int[] parent, int m, int n) {
        return findRoot(parent, m) == findRoot(parent, n);
    }
}