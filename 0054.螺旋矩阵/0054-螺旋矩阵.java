class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int size = matrix.length * matrix[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0;
        int dir = 0;        
        for (int i = 0; i < size; i ++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int nextR = row + dirs[dir][0];
            int nextC = col + dirs[dir][1];
            if (nextR < 0 || nextR >= matrix.length || 
                nextC < 0 || nextC >= matrix[0].length || 
                visited[nextR][nextC] ) {
                dir = (dir + 1) % 4;              
            }
            row += dirs[dir][0];
            col += dirs[dir][1];
        }
        return res;
    }
}