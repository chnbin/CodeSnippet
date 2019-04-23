class Solution {
  public boolean isSubsequence(String s, String t) {
      if (s.length() == 0) { return true; }
      int pos = 0;
      
      for (int i = 0; i < t.length(); i++) {
          if (pos == s.length()) {
              return true;
          } else {
              if (s.charAt(pos) == t.charAt(i) && pos < s.length()) {
              pos++;
              }          
          }

      }
      return (pos == s.length());
  }
}