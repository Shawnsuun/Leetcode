class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        for (char[] row : matrix) {
            for (int i = 0; i < row.length; i ++) {
                if (row[i] == '1') {
                    heights[i] += 1;
                } else {
                    heights[i] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    //Leetcode.84
    private int largestRectangleArea(int[] heights) {
        int maxRec = 0;
        Stack<Integer> temp = new Stack<Integer>();
        temp.push(-1);
        for (int i = 0; i < heights.length; i ++) {
            while (temp.peek() != -1 && heights[temp.peek()] > heights[i]) {
                int poped = temp.pop();
                int width = i - temp.peek() - 1;
                maxRec = Math.max(maxRec, heights[poped] * width);
            }
            temp.push(i);
        }
        //A stack left, in which its height monotonously increase
        while (temp.peek() != -1) {
            int poped = temp.pop();
            int width = heights.length - temp.peek() - 1;
            maxRec = Math.max(maxRec, heights[poped] * width);
        }
        return maxRec;
    }
}