class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        char[] chars = sentence.toCharArray();
        for (char ch : chars) {
            set.add(ch);
            if (set.size() == 26) {
                return true;
            } 
        }
        return false;
    }
}