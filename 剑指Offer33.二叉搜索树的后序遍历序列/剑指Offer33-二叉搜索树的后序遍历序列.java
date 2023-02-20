class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int left, int right) {
        if (left >= right) {    //the range of tree is less than 1 
            return true;
        }
        int pivot = left;   //pivot of left right tree index
        int root = postorder[right];
        while (postorder[pivot] < root) {
            pivot ++;   //pivot at first index of right tree
        }
        int temp = pivot;
        while (temp < right) {
            if (postorder[temp] < root) {   //postorder after pivot should no less than root
                return false;
            }
            temp ++;                        
        }
        return helper(postorder, left, pivot - 1) && helper(postorder, pivot, right - 1);
    }
}