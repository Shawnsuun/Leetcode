class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[row][col];    //record visited route
        //traverse each grid as start point
        for (int i = 0; i < row; i ++) {    
            for (int j = 0; j < col; j ++) {
                if (dfs(board, chars, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
 
    private boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int index) {
        //base case
        if (board[i][j] != chars[index]) {  //different character, cut the line
            return false;
        } else if (index == chars.length - 1) { //chars are the same, and is the last index
            return true;
        }

        int row = board.length;
        int col = board[0].length;
        visited[i][j] = true;
        
        int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean exist = false;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (r >= 0 && r < row && 
                c >= 0 && c < col && 
                !visited[r][c]) {
                boolean flag = dfs(board, chars, visited, r, c, index + 1);
                if (flag) {
                    exist = true;
                    break;
                }
            }
        }
        visited[i][j] = false;  //backtracking
        return exist;
    }
}