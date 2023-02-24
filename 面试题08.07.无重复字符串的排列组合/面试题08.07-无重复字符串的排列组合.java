class Solution {
    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        helper(chars, 0, set);
        String[] res = new String[set.size()];
        int i = 0;
        for (String str : set) {
            res[i ++] = str;
        }
        return res;
    }

    private void helper(char[] chars, int index, Set<String> set) {
        if (index == chars.length) {
            set.add(new String(chars));
        } else {
            for (int i = index; i < chars.length; i ++) {
                swap(chars, index, i);
                helper(chars, index + 1, set);
                swap(chars, index, i);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        if (i != j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}