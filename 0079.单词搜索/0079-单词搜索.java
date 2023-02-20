class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (dfs(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row , int col, char[] chars, int i) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (chars[i] != board[row][col]) {
            return false;
        } else if (i == chars.length - 1) {
            return true;
        }

        char temp = board[row][col];
        board[row][col] = '0';
        int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        boolean res = false;
        for (int[] dir : dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            res = res || dfs(board, r, c, chars, i + 1);
            if (res) {
                return true;
            }        
        }
        board[row][col] = temp;
        return res;
    }
}