class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(0, graph, path, res);
        return res;
    }

    private void dfs(int source, int[][] graph, LinkedList<Integer> path, List<List<Integer>> res) {
        path.add(source);
        if (source == graph.length - 1) {
            res.add(new LinkedList<>(path));
        }
        for (int next : graph[source]) {
            dfs(next, graph, path, res);
        }
        path.removeLast();
    }
}