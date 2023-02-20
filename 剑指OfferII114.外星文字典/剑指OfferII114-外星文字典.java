class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] inDegrees = new int[26];
        Arrays.fill(inDegrees, -1);
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<Character>());
                inDegrees[ch - 'a'] = 0;
            }
        }

        for (int i = 1; i < words.length; i ++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            if (w1.startsWith(w2) && !w1.equals(w2)) {
                return "";
            }
            for (int j = 0; j < w1.length() && j < w2.length(); j ++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        inDegrees[ch2 - 'a'] ++;
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i ++) {
            if (inDegrees[i] == 0) {
                queue.offer((char)(i + 'a'));
            }    
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            builder.append(ch);
            for (char next : graph.get(ch)) {
                inDegrees[next - 'a'] --;
                if (inDegrees[next - 'a'] == 0) {
                    queue.offer(next);
                }
            }
        }
        return builder.length() == graph.size() ? builder.toString() : "";



        
    }
}