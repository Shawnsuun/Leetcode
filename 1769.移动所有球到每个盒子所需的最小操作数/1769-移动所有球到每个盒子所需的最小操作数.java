class Solution {
    public int[] minOperations(String boxes) {
        char[] chars = boxes.toCharArray();
        int len = chars.length;
        int[] res = new int[len];

        int operationsToFirst = 0;
        int leftBalls = chars[0] == '0' ? 0 : 1;
        int rightBalls = 0;
        
        for (int i = 1; i < len; i ++) {
            if (chars[i] == '1') {
                rightBalls ++;
                operationsToFirst += i;
            }
        }
        res[0] = operationsToFirst;

        for (int i = 1; i < len; i ++) {
            res[i] = res[i - 1] + leftBalls - rightBalls;
            if (chars[i] == '1') {
                leftBalls ++;
                rightBalls --;
            }
        }
        return res;
    }
}