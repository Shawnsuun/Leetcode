class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<String>();
        s = s.substring(1, s.length() - 1);
        //separate string into 2 parts(x and y digits) at all possible index
        for (int i = 1; i < s.length(); i ++) {
            String xDigit = s.substring(0, i);
            String yDigit = s.substring(i);
            //for each part get a list of valid num, nested for loop to get the coordinate
            List<String> validX = ValidNum(xDigit);
            List<String> validY = ValidNum(yDigit);
            for (String x : validX) {
                for (String y : validY) {
                    res.add('(' + x + ", " + y +')');
                }                
            }
        }
        return res;
    }

    //helper method to get a list of valid numbers(with or without '.') from a string
    private List<String> ValidNum(String s) {
        List<String> validNums = new ArrayList<String>();
        if (s.equals("0") || s.charAt(0) != '0') {
            validNums.add(s);
        }
        for (int i = 1; i < s.length(); i ++) {
            String intPart = s.substring(0, i);
            String floatPart = s.substring(i);
            if ((intPart.charAt(0) != '0' || intPart.equals("0")) & floatPart.charAt(floatPart.length() - 1) != '0') {
                validNums.add(intPart + '.' + floatPart);
            }
        }
        return validNums;
    }



}