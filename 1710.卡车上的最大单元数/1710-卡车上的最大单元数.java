class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (e1, e2) -> e2[1] - e1[1]);
        int space = truckSize;
        int load = 0;
        for (int[] type : boxTypes) {
            if (space > 0) {
                int unitAdded = Math.min(type[0], space);
                load += unitAdded * type[1];
                space -= unitAdded;
                if (space == 0) {
                    break;
                }
            }
        }
        return load;
    }
}