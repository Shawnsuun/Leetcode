class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }        
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] length = new int[row][col];
        int longest = 0;
        for (int i = 0; i < row; i ++) {
            for (int j = 0 ; j < col; j ++) {
                longest = Math.max(longest, dfs(matrix, length, i, j));
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int[][] length, int i, int j) {
        if (length[i][j] != 0) {
            return length[i][j];
        }
        int len = 1;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length 
                && matrix[r][c] > matrix[i][j]) {
                int path = dfs(matrix, length, r, c);
                len = Math.max(len, path + 1);
            }
        }
        length[i][j] = len;
        return len;
    }
}