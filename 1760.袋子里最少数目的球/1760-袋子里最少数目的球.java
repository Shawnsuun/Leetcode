class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
        }
        //lower and uppaer limit of the ball numbers in a bag
        int left = 1;
        int right = maxNum;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int operations = 0;
            for (int num : nums) {
                operations += (num - 1) / mid;
            }
            //ball numbers in a bag is possible in maxOpts, recuce ball number until left > right
            if (operations <= maxOperations) {  
                right = mid - 1;
            } else if (operations > maxOperations) {
                left = mid + 1;
            }
        }
        return left;
    }
}