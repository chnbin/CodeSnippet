class Solution {
  public int balancedStringSplit(String s) {
      int res = 0;
      int cnt = 0;
      
      for (char c: s.toCharArray()) {
          if (c == 'R') {
              cnt++;
          }
          
          if (c == 'L') {
              cnt--;
          }
          
          if (cnt == 0) {
              res++;
          }
      }
      return res;
  }
}
