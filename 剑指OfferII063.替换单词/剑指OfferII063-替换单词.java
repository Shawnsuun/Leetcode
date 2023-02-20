class Solution {
    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }

        private void insert(String s) {
            TrieNode root = this;
            TrieNode cur = root;
            for (char ch : s.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.isWord = true;
        }

        private String getPrefix(String s) {
            StringBuilder builder = new StringBuilder();
            TrieNode root = this;
            TrieNode cur = root;
            for (char ch : s.toCharArray()) {
                if (cur.children[ch - 'a'] != null) {
                    builder.append(ch);
                } else {
                    break;
                }
                cur = cur.children[ch - 'a'];
                if (cur.isWord) return builder.toString();
            }
            return "";
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String str : dictionary) {
            root.insert(str);
        }
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i ++) {
            String prefix = root.getPrefix(strs[i]);
            if (prefix != "") {
                strs[i] = prefix;
            }
        }
        return String.join(" ", strs);
    }
}

