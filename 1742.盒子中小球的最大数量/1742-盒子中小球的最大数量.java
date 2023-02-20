class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] boxes = new int[46];
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i ++) {
            int box = getBox(i);
            boxes[box] += 1;
            if (boxes[box] > res) {
                res = boxes[box];
            }
        }
        return res;
    }
    
    private int getBox(int num) {
        int k = num;
        int res = 0;
        while (k > 0) {
            res += (k % 10);
            k = k / 10;
        }
        return res;
    }
}

//321 % 10 = 1£¬ 321 / 10 = 32
//32 % 10 = 2£¬ 32 / 10 = 3
//3 % 10 = 3£¬ 3 / 10 = 0
