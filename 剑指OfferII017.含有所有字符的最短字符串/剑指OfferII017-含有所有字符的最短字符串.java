class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }
        //number of chars in t which is not included in substring of s 
        int count = charCount.size();
        int start = 0, end = 0;
        int minStart = 0, minEnd = 0;
        int minLen = Integer.MAX_VALUE;
        while (end < s.length() || end == s.length() && count == 0) {
            if (count > 0) {    //not a eligible substring
                char endChar = s.charAt(end);
                if (charCount.containsKey(endChar)) {
                    charCount.put(endChar, charCount.get(endChar) - 1);
                    if (charCount.get(endChar) == 0) {
                        count --;
                    }
                }
                end ++;
            } else {    //count = 0, eligible substring
                if (end - start < minLen) {     //get eligible substring
                    minLen = end - start;
                    minStart = start;
                    minEnd = end;
                }
                char startChar = s.charAt(start);
                if (charCount.containsKey(startChar)) {
                    charCount.put(startChar, charCount.get(startChar) + 1);
                    if (charCount.get(startChar) == 1) {
                        count ++;
                    }
                }                
                start ++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd);
    }
}