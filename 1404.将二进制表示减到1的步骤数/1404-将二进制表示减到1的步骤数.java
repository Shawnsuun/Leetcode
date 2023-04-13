class Solution {
    public int numSteps(String s) {
        char[] chars = s.toCharArray();
        int steps = 0;
        int carry = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            if (chars[i] == '0') {
                steps += carry == 1 ? 2 : 1;
            } else {
                if (carry == 1) {
                    steps ++;
                } else {
                    if (i != 0) {
                        steps += 2;
                    }
                    carry = 1;
                }
            }
        }
        return steps;
    }
}