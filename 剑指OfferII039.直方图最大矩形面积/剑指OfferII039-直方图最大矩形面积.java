class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(-1);
        int maxArea = 0;
        //traverse heights, example: 2, 1, 5, 6, 2, 3
        for (int i = 0; i < heights.length; i ++) {
            //larger increasing order, 2, 5, 6 are popped
            while (deque.peek() != -1 && heights[deque.peek()] >= heights[i]) {
                int height = heights[deque.pop()];
                int width = i - deque.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            deque.push(i);
        }
        //an increasing stack left: 1, 2, 3
        while (deque.peek() != -1) {
            int height = heights[deque.pop()];
            int width = heights.length - deque.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }        
        return maxArea;
    }
}