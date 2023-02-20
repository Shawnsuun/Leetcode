class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        int len_s = s.length();
        int len_p = p.length();
        int[] counts = new int[26];
        List<Integer> ans = new ArrayList <Integer>();

        if (len_s < len_p) {
            return ans;
        }
        
        for (int i = 0; i < len_p; i ++) {
            counts[p.charAt(i) - 'a'] += 1;
            counts[s.charAt(i) - 'a'] -= 1;
        }

        for (int i = 0; i < len_s - len_p; i ++) {
            if (AllZero(counts)) {
                ans.add(i);
            }
            counts[s.charAt(i) - 'a'] += 1;
            counts[s.charAt(i + len_p) - 'a'] -= 1;
        }

        if (AllZero(counts)) {
            ans.add(len_s - len_p);
        }
        return ans;
    }

    private boolean AllZero(int[] counts) {
        for (int count: counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}