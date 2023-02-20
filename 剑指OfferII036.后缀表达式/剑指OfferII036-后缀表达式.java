class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length() - 1))) {
                deque.push(Integer.parseInt(token));
            } else {
                int popped1 = deque.pop();
                int popped2 = deque.pop();
                deque.push(calculate(popped1, popped2, token));
            }
        }
        return deque.peek();
    }

    private int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
        }
        return 0;
    }
}