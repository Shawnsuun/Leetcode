class MapSum {
    private class TrieNode {
        private TrieNode[] children;
        private int val;
        public TrieNode() {
            children = new TrieNode[26];
            val = 0;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        for (char ch : key.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                return 0;
            }
            cur = cur.children[ch - 'a'];
        }
        return getSum(cur);
    }

    private int getSum(TrieNode node) {
        if (node == null) {
            return 0;
        }
        int res = node.val;
        for (TrieNode child : node.children) {
            if (child != null) {
                res += getSum(child);
            }
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */