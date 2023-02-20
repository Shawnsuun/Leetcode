class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0;
        int c = n - 1;
        while (c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c --;
                if (c < 0) {
                    return false;
                }
            }
            while (matrix[r][c] < target) {
                r ++;
                if (r == m) {
                    return false;
                }
            }
        }
        return false;
    }
}