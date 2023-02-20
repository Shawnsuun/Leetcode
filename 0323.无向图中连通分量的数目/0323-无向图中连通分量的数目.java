class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        /** 
        int[] size = new int[n];
        Arrays.fill(size, 1);
        int max = 1;
        */
        for (int[] edge : edges) {
            int root1 = findRoot(parents, edge[0]);
            int root2 = findRoot(parents, edge[1]);
            if (root1 != root2) {
                parents[root1] = root2;
                n --;
                /**
                size[root2] += size[root1];
                max = Math.max(size[root2], max);
                */
            }
        }
        return n;
        /**
        return max;
        */
    }

    private int findRoot(int[] parents, int root) {
        while (parents[root] != -1) {
            root = parents[root];
        }
        return root;
    }
}