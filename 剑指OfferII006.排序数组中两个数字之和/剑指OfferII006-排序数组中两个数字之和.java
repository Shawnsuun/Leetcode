class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right && numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) {
                left ++;
            } else {
                right --;
            }
        }
        int[] pair = new int[2];
        pair[0] = left;
        pair[1] = right;
        return pair;
    }
}