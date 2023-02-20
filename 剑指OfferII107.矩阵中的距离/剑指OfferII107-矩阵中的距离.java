class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dists = new int[row][col];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            int dist = dists[coord[0]][coord[1]];
            for (int[] dir : dirs) {
                int r = coord[0] + dir[0];
                int c = coord[1] + dir[1];
                if (r >= 0 && r < row && c >=0 && c < col) {
                    if (dists[r][c] > dist + 1) {
                        dists[r][c] = dist + 1;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }
        return dists;
    }
}