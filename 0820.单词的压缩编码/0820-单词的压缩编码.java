class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        root.insert(words);
        int[] counts = {0};
        dfs(root, 1, counts);
        //use an array with 1 int to handle recursion
        return counts[0];
    }

    private class Trie {
        private Trie[] children;

        private Trie() {
            children = new Trie[26];
        }

        private void insert(String[] words) {
            for (String word : words) {
                Trie root = this;
                for (int i = word.length() - 1; i >= 0; i --) {
                    if (root.children[word.charAt(i) - 'a'] == null) {
                        root.children[word.charAt(i) - 'a'] = new Trie();
                    }
                    root = root.children[word.charAt(i) - 'a'];
                }
            }
        }
    }

    //hard part is to create dfs method
    private void dfs(Trie root, int length, int[] counts) {
        boolean isLeaf = true;
        //traverse 26 letters
        for (Trie child : root.children) {
            if (child != null) {
                isLeaf = false;
                dfs(child, length + 1, counts);
            }
        }
        //only when reaching leaf can we add the length
        if (isLeaf) {
            counts[0] += length;
        }
    }
}













