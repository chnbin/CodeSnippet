import java.util.LinkedList;

class Solution {
  public int calculate(String s) {
      int res = 0;
      int num = 0;
      char symbol = '+';
      LinkedList<Integer> stack = new LinkedList<Integer>();
      int index = 0;
      
      while (index < s.length()) {
          char ch = s.charAt(index);
          
          if (isCharANumber(ch)) {
              num = Integer.parseInt(String.valueOf(ch));
              while (((index + 1) < s.length()) && isCharANumber(s.charAt(index+1))) {
                  num = (num * 10) + Integer.parseInt(String.valueOf(s.charAt(index+1)));
                  index++;
              }
          }
          if (s.charAt(index) != ' ') {
              if (symbol == '+') {
                  stack.push(num);
              } else if (symbol == '-') {
                  stack.push(-1*num);
              } else if (symbol == '*') {
                  int tmp = stack.pop();
                  stack.push(num*tmp);
              } else if (symbol == '/') {
                  int tmp = stack.pop();
                  stack.push(tmp/num);
              }
              symbol = s.charAt(index);
              num = 0;
          }
          index++;
      }
      
      while (!stack.isEmpty()) {
          res += stack.pop();
      }
      return res;
  }
  
  private boolean isCharANumber(char ch) {
      if (('0' <= ch) && (ch <= '9')) {
          return true;
      }
      return false;
  }
}