import java.util.LinkedList;

class Solution150 {
  public int evalRPN(String[] tokens) {
      LinkedList<Integer> stack = new LinkedList<Integer>();

      for (String token: tokens) {
          if (token.equals("+")) {
              stack.push(stack.pop() + stack.pop());
          } else if (token.equals("-")) {
              int op2 = stack.pop();
              int op1 = stack.pop();
              stack.push(op1 - op2);
          } else if (token.equals("*")) {
              stack.push(stack.pop() * stack.pop());
          } else if (token.equals("/")) {
              int op2 = stack.pop();
              int op1 = stack.pop();
              stack.push(op1 / op2);
          } else {
              stack.push(Integer.parseInt(token));
          }
      }
      
      return stack.pop();
  }
}