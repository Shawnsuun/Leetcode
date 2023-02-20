class Solution {
    public int[][] findContinuousSequence(int target) {
        int maxNum = (target / 2) + (target % 2);
        List<int[]> seqs = new ArrayList<int[]>();
        int sum = 0;
        int right = 1;
        for (int left = 1; left < maxNum; left ++) {
            sum -= left - 1;
            while (left <= right && sum < target) {
                sum += right;
                right ++;
            }
            if (sum == target) {
                int len = right - left;
                int[] seq = new int[len];
                for (int i = 0; i < len; i ++) {
                    seq[i] = left + i;
                }
                seqs.add(seq);
            }
        }
        int[][] res = new int[seqs.size()][];
        for (int i = 0; i < seqs.size(); i ++) {
            res[i] = seqs.get(i);
        }
        return res;
    }
}