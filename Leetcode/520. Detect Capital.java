class Solution {
  public boolean detectCapitalUse(String word) {
      boolean isAllUpper = true;
      boolean isAllLower = true;
      boolean isTitle = true;
      
      for (int i = 0; i < word.length(); i++) {
          char c = word.charAt(i);
          
          if (!isAllUpper || !(('A' <= c) && (c <= 'Z'))) {
              isAllUpper = false;
          }
          
          if (!isAllLower || !(('a' <= c) && (c <= 'z'))) {
              isAllLower = false;
          }
          
          if (i == 0 && !(('A' <= c) && (c <= 'Z'))) {
              isTitle = false;
          }
          
          if (i > 0 && !(('a' <= c) && (c <= 'z'))) {
              isTitle = false;
          }
      }
      
      return isAllUpper || isAllLower || isTitle;
  }
}