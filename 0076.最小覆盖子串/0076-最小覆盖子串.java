class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();  
        int m = s.length();
        int n = t.length();
        int min_left = 0;
        int min_right = 0;

        if (m < n) {
            return "";
        }  

        for (int i = 0; i < n; i ++) {
            charCounts.put(t.charAt(i), charCounts.getOrDefault(t.charAt(i), 0) + 1);          
        }
        
        //This is where the bug is! should be the size of charCounts, not t.length!
        int moreThanZero = charCounts.size(); 
        int min_len = Integer.MAX_VALUE;

        int left = 0;
        for (int right = 0; right < m; right ++) {
            if (charCounts.containsKey(s.charAt(right))) {
                charCounts.put(s.charAt(right), charCounts.get(s.charAt(right)) - 1);
                if (charCounts.get(s.charAt(right)) == 0) {
                    moreThanZero -= 1;
                    if (moreThanZero == 0 && right - left + 1 < min_len) {
                        min_len = right - left + 1;
                        min_left = left;
                        min_right = right;
                    }
                }
            }

            while (right - left > n - 2 && moreThanZero == 0) {
                if (charCounts.containsKey(s.charAt(left))) {
                    charCounts.put(s.charAt(left), charCounts.get(s.charAt(left)) + 1); 
                    if (charCounts.get(s.charAt(left)) == 1) {
                        moreThanZero += 1;
                    }
                } 
                left += 1;
                if (moreThanZero == 0 && right - left + 1 < min_len) {
                    min_len = right - left + 1;
                    min_left = left;
                    min_right = right;                                 
                } 
            }          
        }

        return min_len == Integer.MAX_VALUE ? "" : s.substring(min_left, min_right + 1);
    }
}