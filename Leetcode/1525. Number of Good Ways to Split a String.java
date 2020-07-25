class Solution {
  public int numSplits(String s) {
      if (s == null || s.length() == 0) { return 0; }
      int res = 0;
      char[] chars = new char[26];
      int n = s.length();
      int[] prefix = new int[n];
      int[] postfix = new int[n];
      
      prefix[0] = 1;
      chars[s.charAt(0) - 'a']++;
      
      for (int i = 1; i < n; i++) {
          if (chars[s.charAt(i) - 'a'] != 1) {
              prefix[i] = prefix[i-1] + 1;
              chars[s.charAt(i) - 'a']++;
          } else {
              prefix[i] = prefix[i - 1];
          }
      }
      
      chars = new char[26];
      postfix[n - 1] = 1;
      chars[s.charAt(n - 1) - 'a']++;
      
      for (int i = n - 2; i >= 0; i--) {
          if (chars[s.charAt(i) - 'a'] != 1) {
              postfix[i] = postfix[i + 1] + 1;
              chars[s.charAt(i) - 'a']++;
          } else {
              postfix[i] = postfix[i + 1];
          }
      }
      
      for (int i = 0; i < n - 1; i++) {
          if (prefix[i] == postfix[i+1]) {
              res++;
          }
      }
      
      return res;
  }
}
