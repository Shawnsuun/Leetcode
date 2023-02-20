class Solution {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        int[] parent = new int[len];
        Arrays.fill(parent, -1);
        for (int i = 0; i < len; i ++) {
            for (int j = i + 1; j < len; j ++) {
                union(parent, strs, i, j);
            }
        }
        int count = 0;
        for (int i : parent) {
            if (i < 0) {
                count ++;
            }
        }
        return count;
    }

    private void union(int[] parent, String[] strs, int i, int j) {
        if (findRoot(parent, j) == findRoot(parent, i)) {
            return;
        } else if (isSimilar(strs[i], strs[j])) {
            parent[findRoot(parent, j)] = findRoot(parent, i);
        }
    }


    private int findRoot(int[] parent, int num) {
        while (parent[num] >= 0) {
            num = parent[num];
        }
        return num;
    }

    private boolean isSimilar(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        int diff = 0;
        for (int i = 0; i < str1.length(); i ++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff ++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}