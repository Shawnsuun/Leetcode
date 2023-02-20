class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        findPrefix(word);
        Trie root = this;
        for (int i = 0; i < word.length(); i ++) {
            if (root.children[word.charAt(i) - 'a'] == null) {
                root.children[word.charAt(i) - 'a'] = new Trie();
            } 
            root = root.children[word.charAt(i) - 'a'];
        }
        root.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = findPrefix(word);
        if (node == null || node.isEnd == false) {
            return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        return findPrefix(prefix) != null;
    }

    private Trie findPrefix(String prefix) {
        Trie root = this;
        for (int i = 0; i < prefix.length(); i ++) {
            if (root.children[prefix.charAt(i) - 'a'] == null) {
                return null;
            }
            root = root.children[prefix.charAt(i) - 'a'];
        }
        return root;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */