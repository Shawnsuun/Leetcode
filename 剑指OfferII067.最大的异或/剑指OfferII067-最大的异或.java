class Solution {
    private class TrieNode {
        private TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = insert(nums);
        int res = 0;
        for (int num : nums) {
            TrieNode cur = root;
            int xor = 0;
            for (int i = 31; i >= 0; i --) {
                int bit = (num >> i) & 1;
                if (cur.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    cur = cur.children[1 - bit];
                } else {
                    xor = xor << 1;
                    cur = cur.children[bit];
                }
            }
            res = Math.max(res, xor);
        }
        return res;
    }

    private TrieNode insert(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = 31; i >= 0; i --) {
                if (cur.children[1 & (num >> i)] == null) {
                    cur.children[1 & (num >> i)] = new TrieNode();
                }
                cur = cur.children[1 & (num >> i)];
            }
        }
        return root;
    }
}