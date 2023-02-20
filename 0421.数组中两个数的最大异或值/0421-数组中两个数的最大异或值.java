class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie root = new Trie();
        root.insert(nums);
        int xor = 0;
        int max = 0;

        for (int num : nums) {
            Trie node = root;
            //traverse from last bit of num
            for (int i = 31; i >= 0; i --) {
                //get bit in index i
                int bit = (num >> i) & 1;
                //a different bit exist
                if (node.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    node = node.children[1 - bit];
                //a different bit not exist
                } else {
                    xor = (xor << 1);
                    node = node.children[bit];
                }
            }
            max = Math.max(xor, max);
        }
        return max;
    }

    private class Trie {
        private Trie[] children;

        private Trie() {
            children = new Trie[2];
        }

        private void insert(int[] nums) {
            for (int num : nums) {
                Trie root = this;
                //from last bit of num, add to trie
                for (int i = 31; i >= 0; i --) {
                    //get bit in index i
                    int bit = (num >> i) & 1;
                    if (root.children[bit] == null) {
                        root.children[bit] = new Trie();
                    }
                    root = root.children[bit];
                }
            }
        }
    }

}