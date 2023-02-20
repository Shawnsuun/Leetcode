class Solution {
    public double largestTriangleArea(int[][] points) {
        double max_s = 0.0;
        int n = points.length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                for (int k = 0; k < n; k ++) {
                    double x1 = points[i][0];
                    double y1 = points[i][1];
                    double x2 = points[j][0];
                    double y2 = points[j][1];
                    double x3 = points[k][0];
                    double y3 = points[k][1];
                    double s = (x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2) / 2;
                    max_s = Math.max(s, max_s);
                }
            }
        }
        return max_s;
    }
}