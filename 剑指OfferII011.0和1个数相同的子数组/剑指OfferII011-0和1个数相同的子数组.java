class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < len; i ++) {
            sum = nums[i] == 0 ? sum - 1 : sum + 1;
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i); 
            }          
        }
        return res;
    }
}