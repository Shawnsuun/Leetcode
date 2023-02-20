class Solution {
    public boolean isPalindrome(String s) {
        int front = 0;
        int end = s.length() - 1;

        while (end - front > 0) {
            while (!Character.isLetterOrDigit(s.charAt(front)) && end - front > 0) {
                front += 1;
            }
            while (!Character.isLetterOrDigit(s.charAt(end)) && end - front > 0) {
                end -= 1;
            }
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            front ++;
            end --;
        }
        return true;
    }
}