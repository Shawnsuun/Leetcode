class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] dists = new int[row][col];  //a matrix saves the distance of nearest 0
        Queue<int[]> queue = new LinkedList<int[]>();   //Queue for BFS
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});  //enque positions of 0, BFS from 0 can search multiple 1
                } else {
                    dists[i][j] = Integer.MAX_VALUE;    //initialize dists of 1 to a max value
                }
            }
        }
        int[][] directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};    //4 directions
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int dist = dists[pos[0]][pos[1]];
            for (int[] direction : directions) {    //boardcasting to 4 directions
                int r = pos[0] + direction[0];
                int c = pos[1] + direction[1];
                if (r >= 0 && r < row && c >= 0 && c < col) {
                    if (dists[r][c] == Integer.MAX_VALUE) {   //if position (r, c) not visited, it will be max value
                        dists[r][c] = dist + 1; //then update dists[r][c]
                        queue.offer(new int[] {r, c}); //BFS from position (r, c)
                    }
                }
            }
        }
        return dists;
    }
}