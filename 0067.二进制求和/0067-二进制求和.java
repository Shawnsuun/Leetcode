class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = i < 0 ? 0: a.charAt(i) - '0';
            int digitB = j < 0 ? 0: b.charAt(j) - '0';
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1: 0;
            sum = sum >= 2 ? sum - 2: sum;
            ans.append(sum); 
            i --;
            j --;
        }
        if (carry == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }
}