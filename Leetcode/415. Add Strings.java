class Solution {
  public String addStrings(String num1, String num2) {
      int i = num1.length() - 1;
      int j = num2.length() - 1;
      int carry = 0;

      String res = "";
      
      while (i >= 0 || j >= 0) {
          int a = 0;
          int b = 0;
          a = (i >= 0) ? num1.charAt(i) - '0' : 0;
          b = (j >= 0) ? num2.charAt(j) - '0' : 0;
          i--;
          j--;
          res = ((a + b + carry) % 10) + res;
          carry = (a + b + carry) / 10;
      }
      return (carry == 1) ? "1" + res: res;
  }
}