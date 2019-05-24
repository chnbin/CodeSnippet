class Solution {
  public int countSegments(String s) {
      if (s == null || s.length() == 0) { return 0; }
      boolean isBlank = false;
      boolean isWord = false;
      int res = 0;
      
      for (char c: s.toCharArray()) {
          if (c == ' ') {
              if (!isBlank && isWord) {
                  res++;
              }
              isWord = false;
              isBlank = true;
          } else {
              isBlank = false;
              isWord = true;
          }
      }
      if (isWord) { res++; }
      return res;
  }
}