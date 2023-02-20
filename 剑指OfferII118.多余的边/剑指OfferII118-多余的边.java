class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, edge[0]);
            maxNode = Math.max(maxNode, edge[1]);
        }
        int[] parents = new int[maxNode + 1];
        for (int i = 0; i < parents.length; i ++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int num1 = edge[0];
            int num2 = edge[1];
            if (!union(parents, num1, num2)) {
                return new int[]{num1, num2};
            }
        }
        return new int[2];

    }

    private boolean union(int[] parents, int i, int j) {
        int rootI = findRoot(parents, i);
        int rootJ = findRoot(parents, j);
        if (rootI != rootJ) {
            parents[rootJ] = rootI;
            return true;
        }
        return false;
    }

    private int findRoot(int[] parents, int i) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return parents[i];
    }
}