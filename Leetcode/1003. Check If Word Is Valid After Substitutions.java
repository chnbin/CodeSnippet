import java.util.LinkedList;

class Solution {
  public boolean isValid(String S) {
      LinkedList<String> stack = new LinkedList<>();
      
      for (int i = 0; i < S.length(); i++) {
          char c = S.charAt(i);
          if (stack.isEmpty()) {
              stack.push("" + c);
              continue;
          }
          if (c == 'a') {
              stack.push("" + c);
          } else if (c == 'b') {
              if (stack.peek().equals("a")) {
                  stack.push(stack.pop() + c);
              } else {
                  stack.push("" + c);
              }
          } else {
              if (stack.peek().equals("ab")) {
                  stack.pop();
              } else {
                  stack.push("" + c);
              }
          }
      }
      return stack.isEmpty();
  }
}