class Solution {
    public int sumNums(int n) {
        //when flag is true, recursion after "||" will stop
        boolean flag = n <= 1 || (n += sumNums(n - 1)) > 0; 
        return n;
    }
}