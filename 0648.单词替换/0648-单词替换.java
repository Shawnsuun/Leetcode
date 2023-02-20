class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Trie trie = new Trie();
        for (String prefix : dictionary) {
            trie.insert(prefix);
        }

        for (int i = 0; i < words.length; i ++) {
            if (trie.getPrefix(words[i]) != "") {
                words[i] = trie.getPrefix(words[i]);
            }
        }
        return String.join(" ", words);
    }

    private class Trie {
        private Trie[] children;
        private boolean isEnd;
        
        private Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        private void insert(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i ++) {
                if (root.children[word.charAt(i) - 'a'] == null) {
                    root.children[word.charAt(i) - 'a'] = new Trie();
                }
                root = root.children[word.charAt(i) - 'a'];
            }
            root.isEnd = true;
        }

        private String getPrefix(String word) {
            StringBuilder builder = new StringBuilder();
            Trie root = this;
            for (int i = 0; i < word.length(); i ++) {
                if (root.isEnd || root.children[word.charAt(i) - 'a'] == null) {
                    break;
                }
                builder.append(word.charAt(i));
                root = root.children[word.charAt(i) - 'a'];
            }
            return root.isEnd ? builder.toString() : "";
        }
    }
}