class Solution {
    public boolean halvesAreAlike(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Map<Character, Integer> map = new HashMap<>();
        for(char vowel : vowels) {
            map.put(vowel, 1);
        }
        int res = 0;
        while (start < end) {
            if (map.get(s.charAt(start)) != null) {
                res ++;
            }
            if (map.get(s.charAt(end)) != null) {
                res --;         
            }
            start ++;
            end --;
        }
        return res == 0;
    }
}