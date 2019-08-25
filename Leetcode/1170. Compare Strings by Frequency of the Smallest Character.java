class Solution {
  public int[] numSmallerByFrequency(String[] queries, String[] words) {
      int n = queries.length;
      int[] res = new int[n];
      
      for (int i = 0; i < n; i++) {
          int fQuery = f(queries[i]);
          
          for (String word: words) {
              int fString = f(word);
              if (fQuery < fString) {
                  res[i]++;
              }
          }
      }
      
      return res;
  }
  
  private int f(String s) {
      int res = 0;
      int[] t1 = new int[26];
          
      for (char c: s.toCharArray()) {
          t1[c - 'a']++;
      }
      
      for (int i = 0; i < t1.length; i++) {
          if (t1[i] > 0) {
              res = t1[i];
              break;
          }
      }
      return res;
  }
} 