class Solution {
  public boolean checkValidString(String s) {
      int leftP = 0;
      
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c != ')') {
              leftP++;
          } else {
              leftP--;
          }
          if (leftP < 0) { return false; }
      }
              
      int rightP = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
          char c = s.charAt(i);
          if (c != '(') {
              rightP++;
          } else {
              rightP--;
          }
          if (rightP < 0) { return false; }
      }

      return true;
  }
}