class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int curr = 0;
        int step = 1;
        while (curr + step < target || (curr + step > target && (curr + step - target) % 2 == 1)) {
            curr += step;
            step ++;
        }
        return step;
    }
}