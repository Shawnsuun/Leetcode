class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long diff = Math.abs(goal - sum);
        int res = 0;
        res += diff / limit;
        res += diff % limit == 0 ? 0 : 1;
        return res;
    }
}