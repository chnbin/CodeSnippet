class Solution {
  public char findKthBit(int n, int k) {
      String s = "0";
      
      for (int i = 1; i < n; i++) {
          String newStr = s + "1" + reserveStr(s);
          s = newStr;
      }
      
      return s.charAt(k - 1);
  }
  
  private String reserveStr(String s) {
      StringBuilder sb = new StringBuilder();
      
      for (int i = s.length() - 1; i >= 0; i--) {
          char c = s.charAt(i);
          if (c == '0') {
              sb.append("1");
          } else {
              sb.append("0");
          }
      }
      
      return sb.toString();
  }
}
