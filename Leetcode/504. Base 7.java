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

  // A faster solution
  public String convertToBase72(int num) {
    int ans = 0;
    int base = 1;
    int signed = 1;
    
    if (num < 0) {
        signed = -1;
        num *= -1;
    }
    
    while (num > 0) {
        ans += ((num % 7) * base);
        num /= 7;
        base *= 10;
    }
    
    return String.valueOf(signed * ans);
}
}