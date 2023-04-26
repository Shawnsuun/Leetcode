int findMin(int* nums, int numsSize){
    int left = 0;
    int right = numsSize - 1;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } else if (nums[mid] < nums[left]) {
            right = mid;
        } else {
            right --;
        }
    }
    return nums[left];      //left = mid = right
}