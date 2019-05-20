import java.util.LinkedList;

class Solution {
  public int calculate(String s) {
      if (s == null || s.length() == 0) {
          return 0;
      }
      int idx = 0;
      int res = 0;
      int sign = 1;
      LinkedList<Integer> valueStack = new LinkedList<>();
      LinkedList<Integer> signStack = new LinkedList<>();
      
      while (idx < s.length()) {
          char ch = s.charAt(idx);
          if (isDigit(ch)) {
              int curr = 0;
              while ((idx < s.length()) && isDigit(s.charAt(idx))) {
                  curr = curr * 10 + (s.charAt(idx) - '0');
                  idx++;
              }
              res += (sign * curr);
              continue;
          } else if (ch == '+') {
              sign = 1;
          } else if (ch == '-') {
              sign = -1;
          } else if (ch == '(') {
              signStack.push(sign);
              valueStack.push(res);
              sign = 1;
              res = 0;
          } else if (ch == ')') {
              res *= signStack.pop();
              res += valueStack.pop();
          }
          idx++;
      }
      return res;
  }
  
  private boolean isDigit(char ch) {
      return (('0' <= ch) && (ch <= '9'));
  }
}