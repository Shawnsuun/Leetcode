class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i ++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                res[i] = -1;
            } else {
                Set<String> visited = new HashSet<>();
                res[i] = dfs(graph, start, end, visited);
            }
        }
        return res;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i ++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);

            graph.putIfAbsent(var1, new HashMap<String, Double>());
            graph.get(var1).put(var2, values[i]);

            graph.putIfAbsent(var2, new HashMap<String, Double>());
            graph.get(var2).put(var1, (1.0 / values[i]));
        }
        return graph;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (start.equals(end)) {
            return 1.0;
        }
        visited.add(start);
        for (Map.Entry<String, Double> entry : graph.get(start).entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double nextValue = dfs(graph, next, end, visited);
                if (nextValue > 0) {
                    return entry.getValue() * nextValue;
                }
            }
        }
        visited.remove(start);
        return -1.0;
    }
}