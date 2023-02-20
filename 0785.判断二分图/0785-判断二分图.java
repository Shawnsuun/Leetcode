class Solution {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] colors = new int[size];   //an array mark node color
        Arrays.fill(colors, -1);    //colors initialized to -1, indicates no color
        for (int i = 0; i < size; i ++) {
            if (colors[i] == -1) {
                if (!setColor(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    //helper method to color the nodes, if conflict founds return false
    private boolean setColor(int[][] graph, int[] colors, int i, int color) {
        //base case
        if (colors[i] == -1) {
            colors[i] = color;  //color the node if it is not colored
        } else {
            return colors[i] == color;  //if node is colored, check if the same color is given
        }
        for (int jointNode : graph[i]) {
            if (!setColor(graph, colors, jointNode, 1 - color)) {   //check joint nodes recursively
                return false;
            }
        }
        return true;
    }
}    