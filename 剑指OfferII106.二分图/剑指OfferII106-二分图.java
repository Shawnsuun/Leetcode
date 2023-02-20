class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i ++) {
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean setColor(int[][] graph, int[] colors, int i, int color) {
        if (colors[i] != -1) {
            return colors[i] == color;
        }
        colors[i] = color;
        for (int neighbor : graph[i]) {
            if (!setColor(graph, colors, neighbor, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}