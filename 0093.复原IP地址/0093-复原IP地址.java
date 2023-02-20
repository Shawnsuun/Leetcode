class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String>();
        backtracking(s, 0, 0, "", "", res);
        return res;
    }
    //int i: index of string, segI: number of '.' added, seg: segement of ip(0~255), ip: ip String
    private void backtracking(String s, int i, int segI, String seg, String ip, List<String> res) {
        //three conditions to get a valid ip: 
        //1. traverse whole string; 2. three "." are used; 3. the last segmeng is valid
        if (i == s.length() && segI == 3 && isValid(seg)) {
            res.add(ip + seg);
            return;
        //two conditions to continue: 
        //1. string not fully traversed; 2. three "." are not all used
        } else if (i < s.length() && segI < 4){
            char ch = s.charAt(i);
            //if seg + ch is valid, then add ch to seg, update index i, and String seg
            if (isValid(seg + ch)) {
                backtracking(s, i + 1, segI, seg + ch, ip, res);
            }
            //if seg have length(can add '.'), and there is available '.'
            //add seg and '.'to ip, update sedI, update String seg to ch to start a new segment 
            if (seg.length() > 0 && segI < 3) {
                backtracking(s, i + 1, segI + 1, "" + ch, ip + seg + ".", res);
            }
        }
    }

    //check if a seg is a valid seg(0~255)
    private boolean isValid(String seg) {
        if (Integer.valueOf(seg) <= 255 && (seg.equals("0") || seg.charAt(0) != '0')) {
            return true;
        }
        return false;
    }
}