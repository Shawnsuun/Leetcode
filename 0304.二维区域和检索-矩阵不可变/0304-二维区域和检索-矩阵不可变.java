class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int row = 0; row < matrix.length; row ++) {
            int rowsum = 0;
            for (int col = 0; col < matrix[0].length; col ++) {
                rowsum += matrix[row][col];
                sums[row + 1][col + 1] = sums[row][col + 1] + rowsum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] +  sums[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */