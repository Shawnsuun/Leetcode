class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        //minutes[i] is true if i in timePoints
        boolean[] minutes = new boolean[1440];
        for (String time : timePoints) {
            if (!minutes[getMinute(time)]) {
                minutes[getMinute(time)] = true;
            } else {
                return 0;
            }
        }
        //get first time point 
        int first = 0, last = 1439;
        for (int i = 0; i <= last; i ++) {
            if (minutes[i]) {
                first = i;
                break;
            }
        }
        //get last time point 
        for (int i = last; i > first; i --) {
            if (minutes[i]) {
                last = i;
                break;
            }            
        }
        //get min time difference
        int res = first - last + 1440;
        int prev = first, cur = prev;
        for (int i = first + 1; i <= last; i ++) {
            if (minutes[i]) {
                cur = i;
                res = Math.min(res, cur - prev);
                prev = cur;
            }
        }
        return res;
    }

    //transfer time to minutes
    private int getMinute(String time) {
        int h1 = Integer.parseInt(time.substring(0, 2));
        int m1 = Integer.parseInt(time.substring(3));
        return 60 * h1 + m1;
    }
}