import java.util.LinkedList;

class Solution {
  public String removeDuplicates(String s, int k) {
      LinkedList<String> stack = new LinkedList<>();
      String res = "";
      
      for (char c: s.toCharArray()) {
          if (stack.isEmpty()) {
              stack.push("" + c);
          } else {
              String sPeek = stack.peek();
              if (sPeek.charAt(0) == c) {
                  sPeek += c;
                  stack.pop();
                  if (sPeek.length() != k) {
                      stack.push(sPeek);
                  }
              } else {
                  stack.push("" + c);
              }
          }
      }
      
      while (!stack.isEmpty()) {
          res = stack.pop() + res;
      }
      return res;
  }
}