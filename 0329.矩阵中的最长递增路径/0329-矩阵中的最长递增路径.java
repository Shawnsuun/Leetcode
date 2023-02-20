class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int longest = 1;
        int[][] paths = new int[m][n];  //save longest path start from i, j
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                int path = dfs(matrix, paths, i, j);
                longest = Math.max(path, longest);
            }
        }
        return longest;
    }

    //find longest path start from i, j by dfs 
    private int dfs(int[][] matrix, int[][] paths, int i, int j) {
        if (paths[i][j] != 0) { //already get longest path from i, j before
            return paths[i][j];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int longest = 1;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};  //4 directions
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < row && c >= 0 && c < col && matrix[r][c] > matrix[i][j]) {
                int path = dfs(matrix, paths, r, c);
                longest = Math.max(longest, path + 1);  //max path length of 4 directions
            }
        }
        paths[i][j] = longest; //update matrix
        return longest; //return result
    }
}