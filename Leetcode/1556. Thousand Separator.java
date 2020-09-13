class Solution {
  public String thousandSeparator(int n) {
      if (n == 0) { return "0"; }
      int pos = 0;
      int len = (n + "").length();

      String res = "";
      
      while (n > 0) {
          pos++;
          int digit = n % 10;
          n = n / 10;
          
          res = digit + res;
          if (pos % 3 == 0 && pos > 0 && pos != len) {
              res = "." + res;
          }
          
          
      }
      
      return res;
  }
  
}
