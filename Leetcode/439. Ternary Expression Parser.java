import java.util.LinkedList;

class Solution {
  public String parseTernary(String expression) {
      if (expression == null || expression.length() == 0) { return ""; }
      expression = reverseExpr(expression.toCharArray());
      
      LinkedList<Character> stack = new LinkedList<>();
      String op = "";
      int len = expression.length();
      int pos = 0;
      
      while (pos < len) {
          char c = expression.charAt(pos);
          if (op.equals("?")) {
              char oprand1 = stack.pop();
              char oprand2 = stack.pop();
              if (c == 'T') {
                  stack.push(oprand1);
              } else if (c == 'F') {
                  stack.push(oprand2);
              }
          } else if (c != ':' && c != '?') {
              stack.push(c);
          }
          
          if (c == ':' || c == '?') {
              op = "" + c;
          } else {
              op = "";
          }
          
          pos++;
      }
      return "" + stack.pop();
  }
  
  private String reverseExpr(char[] expr) {
      int left = 0;
      int right = expr.length - 1;
      while (left < right) {
          char tmp = expr[left];
          expr[left] = expr[right];
          expr[right] = tmp;
          left++;
          right--;
      }
      return new String(expr);
  } 
}