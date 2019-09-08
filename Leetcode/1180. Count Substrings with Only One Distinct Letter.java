class Solution {
  public int countLetters(String S) {
      int res = 0;
      int maxLen = 1;
      char prev = ' ';
      
      for (int i = 0; i < S.length(); i++) {
          char c = S.charAt(i);
          if (i == 0) {
              maxLen = 1;
              prev = c;
          } else {
              if (c == prev) {
                  maxLen++;
              } else {
                  res += (((1 + maxLen) * maxLen) / 2);
                  maxLen = 1;
                  prev = c;
              }
          }
      }
      res += (((1 + maxLen) * maxLen) / 2);
      return res;
  }
}