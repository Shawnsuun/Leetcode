class Solution {
    public int largestRectangleArea(int[] heights) {
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