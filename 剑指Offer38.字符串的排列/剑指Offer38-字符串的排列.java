class Solution {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        backtracking(chars, 0, set);
        int len = set.size();
        String[] res = new String[len];
        int i = 0;
        for (String str : set) {
            res[i] = str;
            i ++;
        }
        return res;
    }

    private void backtracking(char[] chars, int i, Set<String> res) {
        if (i == chars.length) {
            String str = new String(chars);
            res.add(str);
        } else {
            for (int j = i; j < chars.length; j ++) {
                swap(chars, i, j);
                backtracking(chars, i + 1, res);
                swap(chars, i, j);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}