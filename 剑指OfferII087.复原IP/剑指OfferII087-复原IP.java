class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        backtracking(s, 0, 3, new LinkedList<String>(), res);
        return res;
    }

    private void backtracking(String s, int start, int dot, LinkedList<String> ip, List<String> res) {
        if (dot == 0 && isValidSeg(s.substring(start, s.length()))) {
            List<String> temp = new LinkedList<>(ip);
            temp.add(s.substring(start, s.length()));
            res.add(resoreIP(temp));
        } else if (dot > 0) {
            for (int i = start; i < s.length() && i < start + 3; i ++) {
                if (isValidSeg(s.substring(start, i + 1))) {
                    ip.add(s.substring(start, i + 1));
                    backtracking(s, i + 1, dot - 1, ip, res);
                    ip.removeLast();
                }                
            }
        }
    }

    private boolean isValidSeg(String seg) {
        return seg.equals("0") || (seg.length() > 0 && seg.length() <= 3) && 
            (seg.charAt(0) != '0' && Long.valueOf(seg) <= 255);
    }

    private String resoreIP(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
            builder.append(".");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}