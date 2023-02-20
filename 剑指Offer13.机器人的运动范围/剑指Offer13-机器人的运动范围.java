class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];        
        return dfs(visited, 0, 0, k, m, n);
    }

    private int dfs(boolean[][] visited, int i, int j, int k, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || bitSum(i, j) > k) {
            return 0;
        }
        visited[i][j] = true;
        int[][] dirs = {{0, 1}, {1, 0}};
        int res = 1;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            res += dfs(visited, r, c, k, m, n);
        }
        return res;
    }

    private int bitSum(int row, int col) {
        int num = 0;
        while (row != 0) {
            num += row % 10;
            row = row / 10;
        }
        while (col != 0) {
            num += col % 10;
            col = col / 10;
        }
        return num;
    }
}