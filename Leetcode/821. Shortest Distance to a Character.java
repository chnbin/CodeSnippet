class Solution {
  public int[] shortestToChar(String S, char C) {
      int[] res = new int[S.length()];
      int dist = -1;
      
      for (int i = 0; i < res.length; i++) {
          res[i] = Integer.MAX_VALUE;
      }
      
      for (int i = 0; i < S.length(); i++) {
          char c = S.charAt(i);
          
          if (c == C) {
              dist = 0;
              res[i] = dist;
          }
          
          if (dist != -1) {
              res[i] = Math.min(res[i], dist);
              dist++;
          }
      }
      dist = -1;
      for (int i = S.length() - 1; i >= 0 ; i--) {
          char c = S.charAt(i);
          
          if (c == C) {
              dist = 0;
              res[i] = dist;
          }
          
          if (dist != -1) {
              res[i] = Math.min(res[i], dist);
              dist++;
          }
      }
      return res;
  }
}