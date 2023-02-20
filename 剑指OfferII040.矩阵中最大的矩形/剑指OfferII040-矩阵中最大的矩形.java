class Solution {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[matrix[0].length()];
        for (int i = 0; i < matrix.length; i ++) {
            char[] digits = matrix[i].toCharArray();
            for (int j = 0; j < matrix[0].length(); j ++) {
                if (digits[j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] ++;
                }
            }
            maxArea = Math.max(maxArea, getMaxArea(heights));
        }
        return maxArea;
    }

    private int getMaxArea(int[] heights) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i ++) {
            while (deque.peek() != -1 && heights[deque.peek()] > heights[i]) {
                int height = heights[deque.pop()];
                int width = i - deque.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            deque.push(i);
        }
        while (deque.peek() != -1) {
            int height = heights[deque.pop()];
            int width = heights.length - deque.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}