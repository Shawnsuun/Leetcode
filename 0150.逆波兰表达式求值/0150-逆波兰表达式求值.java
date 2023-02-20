class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> mem = new Stack<Integer>();
        for (String token : tokens) {
            switch(token) {
                case "+":
                    int num1 = mem.pop();
                    int num2 = mem.pop();
                    mem.push(num2 + num1);
                    break;
                case "-":
                    num1 = mem.pop();
                    num2 = mem.pop();
                    mem.push(num2 - num1);
                    break;
                case "*":
                    num1 = mem.pop();
                    num2 = mem.pop();
                    mem.push(num2 * num1);
                    break;
                case "/":
                    num1 = mem.pop();
                    num2 = mem.pop();
                    mem.push(num2 / num1);
                    break;
                default:
                    mem.push(Integer.parseInt(token));
            }
        }
        return mem.pop(); 
    }
}