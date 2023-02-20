class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i ++) {
            graph.put(i, new LinkedList<Integer>());
        }
        //build inDegree array
        int[] inDegrees = new int[numCourses];
        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
            inDegrees[prereq[0]] ++;
        }
        //build queue and offer 0 inDegree courses
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i ++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        //iterate courses by topological sort
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[index] = course;
            index ++;
            for (int next : graph.get(course)) {
                inDegrees[next] --;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return index != numCourses ? new int[0] : res;
    }
}