class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i ++) {
            char ch = expression.charAt(i);
            if (ch == ',') {
                continue;
            } else if (ch != ')') {
                stack.push(ch);
            } else {
                int t = 0;
                int f = 0;
                while (stack.peek() != '(') {
                    char c = stack.pop();
                    if (c == 't') {
                        t ++;
                    } else if (c == 'f') {
                        f ++;
                    }
                }
                stack.pop();
                char op = stack.pop();
                char temp = operation(op, t, f);
                stack.push(temp);
            }
        }
        return stack.pop() == 't' ? true : false; 
    }

    private char operation(char op, int t, int f) {
        if (op == '!' && f % 2 == 1) {
            return 't';
        }
        if (op == '&' && f == 0) {
            return 't';
        }
        if (op == '|' && t > 0) {
            return 't';
        }
        return 'f';
    }
}