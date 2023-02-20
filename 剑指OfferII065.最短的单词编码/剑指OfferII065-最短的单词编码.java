class Solution {
    private class TrieNode {
        private TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = buildTrie(words);
        
        int[] sum = {0};
        dfs(root, 1, sum);
        return sum[0];
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String str : words) {
            TrieNode cur = root;
            for (int i = str.length() - 1; i >= 0; i --) {
                char ch = str.charAt(i);
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur = cur.children[ch - 'a'];
            }
        }
        return root;
    }

    private void dfs(TrieNode root, int len, int[] sum) {
        boolean isLeaf = true;
        for (TrieNode child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, len + 1, sum);
            }
        }
        if (isLeaf) sum[0] += len;
    }
}


