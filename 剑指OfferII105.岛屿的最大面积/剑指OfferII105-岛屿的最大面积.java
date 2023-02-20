class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int area = 0;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    area = Math.max(area, getArea(grid, visited, i, j));
                }
            }
        }
        return area;
    }

    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
        Deque<int[]> deque = new LinkedList<>();
        deque.push(new int[]{i, j});
        visited[i][j] = true;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int area = 0;
        while (!deque.isEmpty()) {
            int[] coordinate = deque.pop();
            area ++;
            for (int[] dir : dirs) {
                int r = coordinate[0] + dir[0];
                int c = coordinate[1] + dir[1];
                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !visited[r][c] && grid[r][c] == 1) {
                    deque.push(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return area;
    }
}