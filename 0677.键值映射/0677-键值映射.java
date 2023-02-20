class MapSum {
    private int value;
    private MapSum[] children;

    public MapSum() {
        children = new MapSum[26];
    }
    
    public void insert(String key, int val) {
        MapSum root = this;
        for (int i = 0; i < key.length(); i ++) {
            if (root.children[key.charAt(i) - 'a'] == null) {
                root.children[key.charAt(i) - 'a'] = new MapSum();
            }
            root = root.children[key.charAt(i) - 'a'];
        }
        //set value only in last letter
        root.value = val;
    }
    
    public int sum(String prefix) {
        MapSum root = this;
        for (int i = 0; i < prefix.length(); i ++) {
            //prefix not found in trie, kill loop and return 0
            if (root.children[prefix.charAt(i) - 'a'] == null) {
                return 0;
            }
            root = root.children[prefix.charAt(i) - 'a'];
        }
        //if root "survived" in the loop, start from the final letter of prefix
        return getSum(root);
    }

    //recursion node by node, until end of words in tries
    private int getSum(MapSum root) {
        if (root == null) {
            return 0;
        }
        //if trie do not have string prefix, sum = 0 at start 
        int sum = root.value;
        //from the final letter of prefix, loop 26 children recursively
        for (MapSum child : root.children) {
            sum += getSum(child);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */