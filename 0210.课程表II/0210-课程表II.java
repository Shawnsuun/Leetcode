class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph, key: pre course, value: following courses
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < numCourses; i ++) {
            graph.put(i, new LinkedList<Integer>());
        }
        //build indegree for each course node
        int[] inDegrees = new int[numCourses];
        for (int[] preReq : prerequisites) {
            graph.get(preReq[1]).add(preReq[0]);
            inDegrees[preReq[0]] ++;
        }
        //add course with 0 indegree to queue at start
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i ++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int preCourse = queue.poll();
            res.add(preCourse);
            for (int nextCourse : graph.get(preCourse)) {
                inDegrees[nextCourse] --;
                if (inDegrees[nextCourse] == 0) {   //if indegree of a course get 0, add to queue
                    queue.offer(nextCourse);
                }
            }
        }
        if (res.size() < numCourses) {  //some courses can not be selected
            return new int[0];
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}