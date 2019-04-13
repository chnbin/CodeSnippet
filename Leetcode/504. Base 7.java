import java.util.LinkedList;

class Solution {
  public String convertToBase7(int num) {
      if (num == 0) { return "0"; }
      LinkedList<String> ans = new LinkedList<String>();
      boolean sign = false;
      
      if (num < 0) {
          sign = true;
          num *= -1;
      }

      while (num > 0) {
          String digit = "" + (num % 7);
          ans.push(digit);
          num /= 7;
      }
      
      if (sign == true) { ans.push("-"); }
      
      return String.join("", ans);
  }
}