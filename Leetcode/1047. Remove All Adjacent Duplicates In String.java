import java.util.LinkedList;

class Solution {
  public String removeDuplicates(String S) {
      if (S.length() == 1) { return S; }
      StringBuilder res = new StringBuilder();
      LinkedList<Character> stack = new LinkedList<>();
      
      for (char c: S.toCharArray()) {
          if (stack.isEmpty() || stack.peek() != c) {
              stack.push(c);
          } else {
              stack.pop();
          }
      }
      
      while (!stack.isEmpty()) { res.append(stack.pop()); }
      return res.reverse().toString();
  }
}