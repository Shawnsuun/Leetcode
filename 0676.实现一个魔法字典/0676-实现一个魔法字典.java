class MagicDictionary {
    private MagicDictionary[] children;
    private boolean isWord;

    public MagicDictionary() {
        children = new MagicDictionary[26];
        isWord = false;
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            MagicDictionary root = this;
            for (int i = 0; i < word.length(); i ++) {
                if (root.children[word.charAt(i) - 'a'] == null) {
                    root.children[word.charAt(i) - 'a'] = new MagicDictionary();
                }
                root = root.children[word.charAt(i) - 'a'];
            }
            root.isWord = true;
        }       
    }
    
    public boolean search(String searchWord) {
        MagicDictionary root = this;
        return dfs(root, searchWord, 0 , 1);
    }

    //The dfs method is the hard part
    private boolean dfs(MagicDictionary root, String searchWord, int i, int chance) {
        //traverse entire trie however searchWord is not fully traversed 
        if (root == null) {
            return false;
        }
        //The final occasion to retrurn true
        if (root.isWord && i == searchWord.length() && chance == 0) {
            return true;
        }
        //check the ith letters in searchWord, if chance < 0 and not found, skip and return false
        if (i < searchWord.length() && chance >= 0) {
            boolean found = false;
            //loop 26 objs children array, stop and return true if the word is found
            for (int j = 0; j < 26 && !found; j ++) {
                int nextChance = chance;
                if (j != searchWord.charAt(i) - 'a') {
                    nextChance -= 1;
                }
                found = dfs(root.children[j], searchWord, i + 1, nextChance);
            }
            return found;
        }
        return false;
    }

}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */