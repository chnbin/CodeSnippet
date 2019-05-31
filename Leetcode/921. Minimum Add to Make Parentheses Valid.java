import java.util.LinkedList;

class Solution {
  public int minAddToMakeValid(String S) {
      if (S == null || S.length() == 0) { return 0; }
      LinkedList<Character> stack = new LinkedList<>();
      
      for (char c: S.toCharArray()) {
          if (c == '(') {
              stack.push(c);
          } else {
              if (!stack.isEmpty() && stack.peek() == '(') {
                  stack.pop();
              } else {
                  stack.push(c);
              }
          }
      }
      return stack.size();
  }
}