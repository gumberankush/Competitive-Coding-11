// Time Complexity: O(n) where n is the length of the input string
// Space Complexity: O(n) for the stack

import java.util.Stack;

class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < tokens.length; i++){
            String token = tokens[i];

            if(!isOperator(token)){
                stack.push(Integer.parseInt(token));
            }else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                if(token.equals("+")){
                    stack.push(val1+val2);
                }else if(token.equals("-")){
                    stack.push(val2-val1);
                }else if(token.equals("*")){
                    stack.push(val2*val1);
                }else if(token.equals("/")){
                    stack.push(val2/val1);
                }
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}