class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26]; //for 26 possible chars, each char index is saved in a list
        for (int i = 0; i < 26; i ++) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < s.length(); i ++) {
            pos[s.charAt(i) - 'a'].add(i);   //the list is a ordered increasing list
        }
        int res = words.length;
        for (String word : words) { //check word in words
            if (word.length() > s.length()) {   //word is longer than s, can not be subsequence
                res --;
                continue;   //skip this word
            }
            int pointer = -1;   //the pointer of s, initialize as -1, will update after binary search
            for (int i = 0; i < word.length(); i ++) {  //pointer of word
                char ch = word.charAt(i);
                //ch is not in s, or the index of last ch in s is not larger than index of word
                if (pos[ch - 'a'].isEmpty() || pos[ch - 'a'].get(pos[ch - 'a'].size() - 1) <= pointer) {    
                    res --;
                    break;  //skip this word
                }
                pointer = binarySearch(pos[ch - 'a'], pointer);
            }
        }
        return res;
    }

    //binary search list to get the first index larger than tar
    private int binarySearch(List<Integer> list, int tar) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > tar) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}