class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length) {
            return -1;
        }
        
        int sum1 = 0, sum2 = 0; //get sum of two arrays
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }       
   
        if (sum1 == sum2)   return 0;
        if (sum1 < sum2) {  //swap nums1 and nums2 to make sum1 always larger
            int tempSum = sum1;
            sum1 = sum2;
            sum2 = tempSum;
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int[] contribution = new int[6];    //nums1's and nums2's contribution to reduce difference
        for (int num : nums1) {
            contribution[num - 1] ++;
        }
        for (int num : nums2) {
            contribution[6 - num] ++;;
        }   

        int steps = 0;
        int diff = sum1 - sum2;

        for (int i = 5; i > 0; i --) {
            if (diff / i > 0 && contribution[i] > 0) {
                int op = Math.min(diff / i, contribution[i]);
                contribution[i] -= op;
                diff -= op * i;
                steps += op;
            }
            if (diff == i) {
                steps ++;
                contribution[i] --;
            }
        }
        return steps;
    }
}












