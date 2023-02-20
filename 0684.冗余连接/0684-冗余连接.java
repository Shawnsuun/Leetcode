class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len + 1];
        Arrays.fill(parent, -1);
        int[] res = new int[2];
        for (int[] edge : edges) {
            if (findRoot(parent, edge[0]) == findRoot(parent, edge[1])) {
                res = Arrays.copyOf(edge, 2);
            }
            union(parent, edge[0], edge[1]);
        }
        return res;
    }
    
    private void union(int[] parent, int i, int j) {
        if (findRoot(parent, i) != findRoot(parent, j)) {
            parent[findRoot(parent, j)] = findRoot(parent, i);
        }
    }

    private int findRoot(int[]parent, int i) {
        while (parent[i] >= 0) {
            i = parent[i];
        }
        return i;
    }
}