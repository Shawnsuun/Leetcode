class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new LinkedList<Integer>();
        List<List<Integer>> paths = new LinkedList<List<Integer>>();
        dfs(graph, 0, path, paths);
        return paths;
    }

    private void dfs(int[][] graph, int i, List<Integer> path, List<List<Integer>> paths) {
        path.add(i);
        if (i == graph.length - 1) {
            paths.add(new LinkedList<Integer>(path));   //add a copy of path
        } else {
            for (int next : graph[i]) {
                dfs(graph, next, path, paths);
            } 
        }
        path.remove(path.size() - 1);   //backtracking
    }
}