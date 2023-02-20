class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]) {
                return middle;
            } else if (arr[middle] > arr[middle - 1] && arr[middle] < arr[middle + 1]) {
                left = middle + 1;
            } else if (arr[middle] < arr[middle - 1] && arr[middle] > arr[middle + 1]) {
                right = middle - 1;
            }
        }
        return - 1;
    }
}