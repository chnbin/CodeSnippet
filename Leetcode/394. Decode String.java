import java.util.LinkedList;

class Solution {
  public String decodeString(String s) {
      LinkedList<Integer> numStack = new LinkedList<>();
      LinkedList<String> strStack = new LinkedList<>();
      StringBuilder currStr = new StringBuilder();
      int len = s.length();
      int pos = 0;
      
      while (pos < len) {
          char c = s.charAt(pos);
          
          if (Character.isDigit(c)) {
              int num = c - '0';
              while (pos + 1 < len && Character.isDigit(s.charAt(pos + 1))) {
                  num = (num * 10) + (s.charAt(pos + 1) - '0');
                  pos++;
              }
              numStack.push(num);
          } else if (c == '[') {
              strStack.push(currStr.toString());
              currStr = new StringBuilder();
          } else if (c == ']') {
              StringBuilder tmp = new StringBuilder(strStack.pop());
              int repeat = numStack.pop();
              
              for (int i = 0; i < repeat; i++) {
                  tmp.append(currStr);
              }
              currStr = tmp;
          } else {
              currStr.append(c);
          }
          
          pos++;
      }
      
      return currStr.toString();
  }
}