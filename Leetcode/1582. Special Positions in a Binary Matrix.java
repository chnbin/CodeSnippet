class Solution {
  public int numSpecial(int[][] mat) {
      int m = mat.length;
      int n = mat[0].length;
      int res = 0;
      int[] rows = new int[m];
      int[] cols = new int[n];
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (mat[i][j] == 1) {
                  rows[i]++;
                  cols[j]++;
              }
          }
      }
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (mat[i][j] == 1 &&
                  rows[i] == 1 &&
                  cols[j] == 1) {
                  res++;
              }
          }
      }
      
      return res;
  }
}