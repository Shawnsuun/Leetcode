class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i ++) {
            int dis = manhattanDis(x, y, points[i][0], points[i][1]);
            if (dis >= 0 && dis < minDis) {
                minDis = dis;
                index = i;
            }
        } 
        return index;
    }

    private int manhattanDis(int x1, int y1, int x2, int y2) {
        if (x1 == x2 || y1 == y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }
        return -1;
    }
}