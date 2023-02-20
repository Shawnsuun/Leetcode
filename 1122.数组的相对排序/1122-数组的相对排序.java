class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        int[] sortedArr1 = new int[arr1.length];
        
        for (int num : arr1) {
            counts[num] ++;
        }

        int i = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                counts[num] --;
                sortedArr1[i] = num;
                i ++;
            }
        }
        for (int num = 0; i < arr1.length; num ++) {
            while (counts[num] > 0) {
                counts[num] --;
                sortedArr1[i] = num;
                i ++;
            }
        }
        return sortedArr1;
    }
}