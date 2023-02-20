class Solution {
    public int numSimilarGroups(String[] strs) {
        int[] parents = new int[strs.length];
        for (int i = 0; i < strs.length; i ++) {
            parents[i] = i;
        }
        for (int i = 0; i < strs.length; i ++) {
            for (int j = i + 1; j < strs.length; j ++) {
                if (isSimilar(strs[i], strs[j])) {
                    union(parents, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < parents.length; i ++) {
            if (parents[i] == i) {
                res ++;
            }
        }
        return res;
    }

    private int findRoot(int[] parents, int i) {
        while (parents[i] != i) {
            i = parents[i];
        }
        return parents[i];
    }

    private void union(int[] parents, int i, int j) {
        int rootI = findRoot(parents, i);
        int rootJ = findRoot(parents, j);
        if (rootI != rootJ) {
            parents[rootJ] = rootI;
        }
    }

    private boolean isSimilar(String str1, String str2) {
        int diffChar = 0;
        for (int i = 0; i < str1.length(); i ++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffChar ++;
            }
            if (diffChar > 2) {
                return false;
            }
        }
        return true;
    }
}