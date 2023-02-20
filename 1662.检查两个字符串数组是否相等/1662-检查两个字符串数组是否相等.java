class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (String word : word1) {
            builder1.append(word);
        }
        for (String word : word2) {
            builder2.append(word);
        }
        if (builder1.toString().equals(builder2.toString())){
            return true;
        }
        return false;        
    }
    
}