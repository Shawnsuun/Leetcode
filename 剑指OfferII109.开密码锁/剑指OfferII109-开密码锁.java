class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String init = "0000";
        if (dead.contains(init) || dead.contains(target)) {
            return -1;
        }
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        queue1.offer(init);
        visited.add(init);
        int steps = 0;
        while (!queue1.isEmpty()) {
            String word = queue1.poll();
            if (word.equals(target)) {
                return steps;
            }
            List<String> neighbors = getNeighbors(word);
            for (String str : neighbors) {
                if (!dead.contains(str) && !visited.contains(str)) {
                    queue2.offer(str);
                    visited.add(str);
                }
            }
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                steps ++;
            }
        }
        return -1;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            char temp = chars[i];
            char ch = temp == '9' ? '0' : (char)(temp + 1);
            chars[i] = ch;
            neighbors.add(new String(chars));
            chars[i] = temp;
            ch = temp == '0' ? '9' : (char)(temp - 1);
            chars[i] = ch;
            neighbors.add(new String(chars));
            chars[i] = temp;
        }
        return neighbors;
    }
}