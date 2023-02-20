class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set1 = new HashSet<String>();    //set to store node from start to search
        Set<String> set2 = new HashSet<String>();    //set to store node from end to search
        Set<String> notVisited = new HashSet<String>(wordList); //dynamically record nodes not visited
        if (!notVisited.contains(endWord)) {
            return 0;
        }
        int len = 2;
        set1.add(beginWord);
        set2.add(endWord);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            if (set2.size() < set1.size()) {  //always keep set1 size smaller to reduce search range
                Set<String> temp = set1;
                set1 = set2;
                set2 = temp;
            }
            Set<String> set3 = new HashSet<String>(); //set3 stores the joint nodes
            for (String word : set1) {
                List<String> jointWords = getJointWords(word);  //get joint nodes of word
                for (String jointWord : jointWords) {
                    if (set2.contains(jointWord)) {
                        return len; //meet in the half way
                    }
                    if (notVisited.contains(jointWord)) {   //joint node is not visited, add to set3
                        set3.add(jointWord);
                        notVisited.remove(jointWord);   //remove joint node from Set notVisited
                    }
                }                
            }
            len ++;
            set1 = set3;
        }
        return 0;
    }

    private List<String> getJointWords(String word) {   //get a list of all possible joint words
        List<String> jointWords = new ArrayList<String>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i ++) {
            char temp = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch ++) {
                if (chars[i] != ch) {   //joint word can not be the same as original word
                    chars[i] = ch;
                    jointWords.add(new String(chars));
                }
            }
            chars[i] = temp;
        }
        return jointWords;
    }
}