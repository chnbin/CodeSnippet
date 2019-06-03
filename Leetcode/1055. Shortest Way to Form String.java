class Solution {
  public int shortestWay(String source, String target) {
      /**
       * Case 1:
       * source = abc, target = abcbc
       * abc bc
       * ^^^ ^^
       * abc is subsequence of source, bc is subsequence of source. Target is consisted of 2 subsequence of source.
       * 
       * Case 2:
       * source = abc, target = abdbc
       * abdbc
       * ^^X
       * ab is subsequence of source but d is not subsequence of source. Return -1.
       * 
       * Case 3:
       * source = xyz, target = xzyxz
       * xz y xz
       * ^^ ^ ^^
       * arget is consisted of 3 subsequence of source.
       */
      int res = 0;
      int pos = 0;
      int m = source.length();
      int n = target.length();
      
      while (pos < n) {
          int start = pos;
          
          // To check any subsequence of source from pos.
          for (int i = 0; i < m; i++) {
              if (pos < n && source.charAt(i) == target.charAt(pos)) {
                  pos++;
              }
          }
          
          // No subsequence of source
          if (start == pos) {
              return -1;
          }
          res++;
      }
      return res;
  }
}