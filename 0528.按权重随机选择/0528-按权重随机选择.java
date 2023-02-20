class Solution {
    private int[] meter;
    private int sum;

    //trans the array to the sums: w = [1, 2, 3, 4] -> sum = [1, 3, 6, 10] for example
    public Solution(int[] w) {
        sum = 0;
        meter = new int[w.length];
        for (int i = 0; i < w.length; i ++) {
            sum += w[i];
            meter[i] = sum;
        }
    }
    
    public int pickIndex() {
        //w = [1, 2, 3, 4] as example, get a random number in 0 ~ 9
        Random random = new Random();
        int ranNum = random.nextInt(sum);
        int left = 0;
        //w = [1, 2, 3, 4] as example, left = 0, right = 3
        int right = meter.length - 1;
        /** 
        The problem becomes to find first num larger than ranNum from [1, 3, 6, 10], and get the index
        under the condition: meter[middle] > ranNum, meter[middle - 1] must <= ranNum to get the answer
        example: if ranNum = 5, the first num > ranNum is 6 and the result is its index 2
        example: if ranNum = 6, the first num > ranNum is 10 and the result is its index 3        
        */
        while (left <= right) {
            //meter[middle] == ranNum, return the next index of middle
            int middle = (left + right) / 2;
            if (meter[middle] == ranNum) {
                return middle + 1;
            //meter[middle] != ranNum, similar as insert position(lc 035), the answer would be left
            } else if (meter[middle] > ranNum) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */