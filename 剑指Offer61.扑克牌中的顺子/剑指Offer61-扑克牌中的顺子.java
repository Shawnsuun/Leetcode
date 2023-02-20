class Solution {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);

        for (int i = 0; i < 4; i ++) {
            if (nums[i] == 0) {
                joker ++;
            } else if (nums[i + 1] == nums[i]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;   //nums[4]: max num; num[joker]: min num, 0 not included
    }
}