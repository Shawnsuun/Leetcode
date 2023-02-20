class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] visited = new boolean[row][col];
        int size = row * col;
        int[] res = new int[size];

        int r = 0;
        int c = 0;

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};   //right, down, left, up
        int dir = 0;    //move right
        for (int i = 0; i < size; i ++) {
            res[i] = matrix[r][c];
            visited[r][c] = true;
            int nextR = r + dirs[dir][0];
            int nextC = c + dirs[dir][1];
            if (nextR < 0 || nextR >= row ||
                nextC < 0 || nextC >= col ||
                visited[nextR][nextC]) {
                dir = (dir + 1) % 4;
            }
            r += dirs[dir][0];
            c += dirs[dir][1];
        }
        return res;
    }
}