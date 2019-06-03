import java.util.Arrays;

class Solution {
  public int findContentChildren(int[] g, int[] s) {
      // Sort g and s, let two arrays start from small to large.
      Arrays.sort(g);
      Arrays.sort(s);
      int res = 0;
      int i = 0;
      int j = 0;
      
      // Two pointers from 0
      while (i < g.length && j < s.length) {
          if (s[j] >= g[i]) {
              res++;
              i++;
              j++;
          } else {
              j++;
          }
      }
      
      return res;
  }
}