class Solution {
  public int numKLenSubstrNoRepeats(String S, int K) {
      if (S.length() < K) { return 0; }
      
      int[] charTable = new int[26];
      int counter = 0;
      int res = 0;
      
      for (int i = 0; i < K; i++) {
          charTable[S.charAt(i) - 'a']++;
          if (charTable[S.charAt(i) - 'a'] == 1) {
              counter++;
          }
      }
      
      res = (K == counter) ? 1 : 0;
      
      for (int i = K; i < S.length(); i++) {
          char prev = S.charAt(i - K);
          charTable[prev - 'a']--;
          if (charTable[prev - 'a'] == 0) {
              counter--;
          }
          
          char curr = S.charAt(i);
          charTable[curr - 'a']++;
          if (charTable[curr - 'a'] == 1) {
              counter++;
          }
          res = (K == counter) ? res + 1 : res;
      }
      return res;
  }
}