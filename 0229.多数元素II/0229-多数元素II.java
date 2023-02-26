class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<>();
        int majority1 = 0;
        int majority2 = 0;
        int votes1 = 0;
        int votes2 = 0;
        for (int num : nums) {
            if (votes1 != 0 && majority1 == num) {  //increase votes1
                votes1 ++;  
            } else if (votes2 != 0 && majority2 == num) {   //increase votes2
                votes2 ++;
            } else if (votes1 == 0) {  //update new majority1
                majority1 = num;
                votes1 ++;
            } else if (votes2 == 0) {   //update new majority2
                majority2 = num;    
                votes2 ++;
            } else {    //eleminate 3 elements
                votes1 --;
                votes2 --;
            }
        }
        int cnts1 = 0;
        int cnts2 = 0;
        for (int num : nums) {
            if (votes1 > 0 && num == majority1) {
                cnts1 ++;
            }
            if (votes2 > 0 && num == majority2) {
                cnts2 ++;
            }
        }
        if (cnts1 > nums.length / 3) {
            res.add(majority1);
        }
        if (cnts2 > nums.length / 3) {
            res.add(majority2);
        }
        return res;
    }
}