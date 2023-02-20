class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> notVisited = new HashSet<>(wordList);
        if (!notVisited.contains(endWord)) {
            return 0;
        }
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        int len = 2;
        set1.add(beginWord);
        set2.add(endWord);
        notVisited.remove(endWord);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set1.size() > set2.size()) {
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            Set<String> set3 = new HashSet<>();
            for (String str : set1) {
                List<String> neighbors = getNeighbors(str);
                for (String neighbor : neighbors) {
                    if (set2.contains(neighbor)) {
                        return len;
                    }
                    if (notVisited.contains(neighbor)) {
                        set3.add(neighbor);
                        notVisited.remove(neighbor);
                    }
                }          
            }
            len ++;
            set1 = set3;  
        }
        return 0;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new LinkedList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            char temp = chars[i];
            for (char alter = 'a'; alter <= 'z'; alter ++) {
                if (alter != temp) {
                    chars[i] = alter;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = temp;
        }
        return neighbors;
    }
}