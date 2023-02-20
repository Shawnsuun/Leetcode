class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        List<Integer> res = new LinkedList<>();
        if (len1 < len2) {
            return res;
        }

        int[] window = new int[26], target = new int[26];
        char[] chars1 = s.toCharArray(), chars2 = p.toCharArray();
        for (int i = 0; i < len2; i ++) {
            window[chars1[i] - 'a'] ++;
            target[chars2[i] - 'a'] ++;
        }

        for (int i = 0; i < len1 - len2; i ++) {
            if (Arrays.equals(window, target)) {
                res.add(i);
            }            
            window[chars1[i] - 'a'] --;
            window[chars1[i + len2] - 'a'] ++;
        }
        if (Arrays.equals(window, target)) {
            res.add(len1 - len2);
        }  
        return res;         
    }
}