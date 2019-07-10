class Solution {
  public boolean repeatedSubstringPattern(String s) {
      if (s == null || s.length() == 0) { return false; }
      int n = s.length();
      for (int i = 1; i <= (n/2); i++) {
          if ((n%i) == 0) {
              String subStr = s.substring(0, i);
              if (s.equals(combineString(subStr, n/i))) {
                  return true;
              }
          }
      }
      
      return false;
  }
  
  private String combineString(String str, int times) {
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < times; i++) { sb.append(str); }
      return sb.toString();
  }
}