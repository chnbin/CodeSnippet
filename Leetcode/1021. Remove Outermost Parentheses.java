import java.util.LinkedList;

class Solution {
  public String removeOuterParentheses(String S) {
      if (S == null || S.length() == 0) { return ""; }
      /**
       * Traverse S, if char is '(', plus 1. If char is ')', minus 1.
       * Case 1;
       * (()())(())
       * 1212101210
       *  ^^^^  ^^    
       * 
       * Case 2:
       * (()())(())(()(()))
       * 121210121012123210
       *  ^^^^  ^^  ^^^^^^
       * We can find that ^^^ part is answer.
       */
      LinkedList<Character> stack = new LinkedList<Character>();
      StringBuilder res = new StringBuilder();
      int pos = 0;
      
      for (int i = 0; i < S.length(); i++) {
          char c = S.charAt(i);
          
          if (c == '(') {
              stack.push(c);
          } else {
              stack.pop();
              if (stack.isEmpty()) {
                  res.append(S.substring(pos + 1, i));
                  pos = i + 1;
              }
          }
      }
      return res.toString();
  }
}