class Solution {
    public int waysToSplit(int[] nums) {
        //Get prefix sum
        int size = nums.length;
        int[] sums = new int[size];
        sums[0] = nums[0];
        for (int n = 1; n < size; n ++) {
            sums[n] = nums[n] + sums[n - 1];
        }

        long counts = 0;
        int maxLeft = 1 + sums[size - 1] / 3;
        int left = 1;
        int right = 1;
        //1st cut after index i to devide left & middle, loop all possible i
        for (int i = 0; i < size - 2 && sums[i] <= maxLeft; i ++) {
            left = Math.max(i + 1, left);
            right = Math.max(i + 1, right);
            //Find right boundry of 2nd cut, sumOfRight <= sumOfMiddle, cut after right - 1
            while (right < size - 1 && sums[right] - sums[i] <= sums[size - 1] - sums[right]) {
                right ++;
            }
            //Find left boundry of 2nd cut, sumOfLeft <= sumOfMiddle
            //use '<', when sumOfLeft = sumOfMiddle, stop loop and get leftmost value
            while (left < right && sums[left] - sums[i] < sums[i]) {
                left ++;
            }
            //(right - 1) - left + 1
            counts += right - left;
        }
        return (int) (counts % 1000000007);
    }
}