class Solution {
  public String interpret(String command) {
      String res = "";
      
      int pos = 0;
      while (pos < command.length()) {
          char c = command.charAt(pos);
          
          if (c == 'G') {
              res += c;
              pos++;
          } else if (c == '(' && command.charAt(pos + 1) == ')') {
              res += "o";
              pos += 2;
          } else {
              res += "al";
              pos += 4;
          }
      }
      
      return res;
  }
}
