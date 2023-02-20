class Solution {
    public int add(int a, int b) {
        while (b != 0) {    //after adding carry, new carry may emerge, loop until carry = 0 
            int carry = (a & b) << 1;   //get all carry produced by a add b
            a = a ^ b;  //result of add with no consideration of carry
            b = carry;  //use carry as b, which is new number to be added
        }
        return a;
    }
}