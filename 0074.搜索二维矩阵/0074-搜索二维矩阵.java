class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[getRow(mid, n)][getCol(mid, n)] == target) {
                return true;
            } else if (matrix[getRow(mid, n)][getCol(mid, n)] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    private int getRow(int num, int n) {
        return num / n;
    }

    private int getCol(int num, int n) {
        return num % n;
    }
}