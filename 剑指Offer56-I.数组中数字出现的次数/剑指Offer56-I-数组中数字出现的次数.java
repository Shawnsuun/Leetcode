class Solution {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;     //XOR of the two singlular numbers
        }
        int diffBit = 0;
        while (((xor >> diffBit) & 1) != 1) {
            diffBit ++;     //an index of different bits of two singlular numbers
        }

        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if (((num >> diffBit) & 1) != 1) {  //group1: the diffbit is 1
                num1 ^= num;
            } else {        //group2: the diffBit is 0
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }
}