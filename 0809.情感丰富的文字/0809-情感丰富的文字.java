class Solution {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String word : words) {
            if (isExpressive(s, word)) {
                res ++;
            }
        }
        return res;
    }

    private boolean isExpressive(String s, String word) {
        int ptr1 = 0, ptr2 = 0;
        char[] chars1 = s.toCharArray(), chars2 = word.toCharArray();
        int len1 = chars1.length, len2 = chars2.length;
        while (ptr1 < len1 && ptr2 < len2) {    //either s or word is traversed will end the loop
            if (chars1[ptr1] != chars2[ptr2]) {
                return false;
            }
            int groupLen1 = 0;
            char ch = chars1[ptr1]; //use char in s to compare
            //skip repetitive chars, jump to the next different char, record length
            while (ptr1 < len1 && chars1[ptr1] == ch) {
                ptr1 ++;
                groupLen1 ++;
            }
            int groupLen2 = 0;
            //skip repetitive chars, jump to the next different char, record length
            while (ptr2 < len2 && chars2[ptr2] == ch) {
                ptr2 ++;
                groupLen2 ++;
            }
            if (groupLen1 < groupLen2) {    //group is reduced
                return false;
            }
            if (groupLen1 > groupLen2 && groupLen1 < 3) {   //group expand to less than 3 chars
                return false;
            }
        }
        return ptr1 == len1 && ptr2 == len2;    //if is expressive, 2 pointers should both at the end
    }
}