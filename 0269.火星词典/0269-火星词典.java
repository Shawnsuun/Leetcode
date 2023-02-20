class Solution {
    public String alienOrder(String[] words) {
        //build graph, key: char in words, val: chars behind key char
        //inDegrees, key: char in words, val: indegree of the key char
        Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> inDegrees = new HashMap<Character, Integer>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i ++) {
                graph.putIfAbsent(word.charAt(i), new HashSet<Character>());
                inDegrees.putIfAbsent(word.charAt(i), 0);
            }
        }

        for (int i = 0; i < words.length - 1; i ++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.startsWith(word2) && !word1.equals(word2)) {  //edging case
                return "";
            }
            for (int j = 0; j < word1.length() && j < word2.length(); j ++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {    //same mapping is only added once
                        graph.get(ch1).add(ch2);
                        inDegrees.put(ch2, inDegrees.get(ch2) + 1);
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<Character>();
        for (Character ch : inDegrees.keySet()) {
            if (inDegrees.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Character chSmall = queue.poll();
            builder.append(chSmall);
            for (Character chLarge : graph.get(chSmall)) {
                inDegrees.put(chLarge, inDegrees.get(chLarge) - 1);
                if (inDegrees.get(chLarge) == 0) {
                    queue.offer(chLarge);
                }
            }
        }
        if (builder.length() != graph.size()) { //circle exists, no vaild order
            return "";
        }
        return builder.toString();
    }
}