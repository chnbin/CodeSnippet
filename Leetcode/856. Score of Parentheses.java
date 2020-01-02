class Solution {
  public int scoreOfParentheses(String S) {
      LinkedList<Integer> stack = new LinkedList<>();
      int res = 0;
      
      for (char c: S.toCharArray()) {
          if (c == '(') {
              stack.push(-1);
          } else {
              int top = stack.pop();
              if (top == -1) {
                  stack.push(1);
              } else {
                  while (stack.peek() != -1) {
                      top += stack.pop();
                  }
                  stack.pop();
                  stack.push(2*top);
              }
          }
      }
      
      while (!stack.isEmpty()) {
          res += stack.pop();
      }
      
      return res;
  }
}