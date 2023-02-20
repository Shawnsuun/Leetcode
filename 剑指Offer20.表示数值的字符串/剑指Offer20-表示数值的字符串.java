class Solution {
    public boolean isNumber(String s) {
        s = s.strip().toLowerCase();
        if (s.startsWith("e") || s.endsWith("e")) {
            return false;
        }
        String[] parts = s.split("e", 2);
        boolean leftPart = isInt(parts[0]) || isSignedInt(parts[0]) || isFloat(parts[0]);
        if (parts.length == 1) {
            return isSignedInt(parts[0]) || isFloat(parts[0]);
        }
        boolean rightPart = isSignedInt(parts[1]);
        return leftPart && rightPart;
    }

    private boolean isInt(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] digits = s.toCharArray();
        for (char digit : digits) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSignedInt(String s) {
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        return isInt(s);
    }

    private boolean isFloat(String s) {
        if (s.startsWith("+") || s.startsWith("-")) {
            s = s.substring(1);
        }
        if (s.startsWith(".")) {
            return isInt(s.substring(1));
        }
        if (s.endsWith(".")) {
            return isInt(s.substring(0, s.length() - 1));
        }
        String[] parts = s.split("\\.", 2);
        return isInt(parts[0]) && isInt(parts[1]);
    }   

}