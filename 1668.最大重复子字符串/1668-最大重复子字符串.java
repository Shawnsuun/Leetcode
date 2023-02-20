class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String repWord = word;
        while (sequence.indexOf(repWord) != -1) {
            repWord += word;
            count += 1;
        }
        return count;
    }
}