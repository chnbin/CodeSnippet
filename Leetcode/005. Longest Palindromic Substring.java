class Solution {
  public String longestPalindrome(String s) {
      if (s == null || s.length() == 0) {
          return "";
      }
      int len = s.length();
      int maxLen = 0;
      char[] res = new char[1];
      boolean[][] dp = new boolean[len][len];
      
      for (int i = 0; i < len; i++) {
          dp[i][i] = true;
      }
      
      for (int i = len - 1; i >= 0; i--) {
          for (int j = i; j < len; j++) {
              if (j == i + 1) {
                  dp[i][j] = (s.charAt(i) == s.charAt(j));
              }
              if (j >= i + 2) {
                  dp[i][j]= (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
              }
              if (dp[i][j]) {
                  if (j-i+1 > maxLen) {
                      maxLen = j - i + 1;
                      res = s.substring(i, j + 1).toCharArray();
                  }
              }
          }
      }
      return new String(res);
  }
}