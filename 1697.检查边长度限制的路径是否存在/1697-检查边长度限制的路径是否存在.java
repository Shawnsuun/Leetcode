class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (x, y) -> x[2] - y[2]);   //sort edgelist by length

        Integer[] index = new Integer[queries.length];     //reflect the distance order of queries
        for (int i = 0; i < queries.length; i ++) {
            index[i] = i;
        }
        Arrays.sort(index, (x, y) -> queries[x][2] - queries[y][2]);    //index[0] is the index of shortest dis in queries
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i ++) {
            parent[i] = i;
        }
        boolean[] res = new boolean[queries.length]; 
        int k = 0;  //minimum edge which is no less than last query's dis
        for (int i : index) {   //traverse queries from short distance
            //if distance in edgelist lower than current query, connect nodes
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                connect(parent, edgeList[k][0], edgeList[k][1]);
                k ++;
            }
            res[i] = isConnected(parent, queries[i][0], queries[i][1]);
        }

        return res;
    }

    private int findRoot(int[] parent, int r) {
        int i = r;
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    private void connect(int[] parent, int a, int b) {
        int rootA = findRoot(parent, a);
        int rootB = findRoot(parent, b);
        parent[rootA] = rootB;

    }

    private boolean isConnected(int[] parent, int a, int b) {
        return findRoot(parent, a) == findRoot(parent, b);
    }
}