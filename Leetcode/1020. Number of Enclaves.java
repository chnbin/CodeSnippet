class Solution {
  public int numEnclaves(int[][] A) {
      if (A == null || A.length == 0 || A[0].length == 0) {
          return 0;
      }
      int m = A.length;
      int n = A[0].length;
      int res = 0;

      // Step 1:
      // To scan all cell of boundary and if number of cell is 1, using dfs to flip
      // all 1 to -1.
      // 0 1 1 0    0 -1 -1 0
      // 0 0 1 0 => 0  0 -1 0
      // 0 0 1 0    0  0 -1 0
      // 0 0 0 0    0. 0. 0 0
      
      // Step 2:
      // Traversal matrix , counting 1s.
      
      // First row
      for (int i = 0; i < n; i++) {
          if (A[0][i] == 1) {
              dfs(A, 0, i, m, n);
          }
      }
      
      // Last row
      for (int i = 0; i < n; i++) {
          if (A[m-1][i] == 1) {
              dfs(A, m - 1, i, m, n);
          }
      }
      
      // First column
      for (int i = 0; i < m; i++) {
          if (A[i][0] == 1) {
              dfs(A, i, 0, m, n);
          }
      }
      
      // Last column
      for (int i = 0; i < m; i++) {
          if (A[i][n-1] == 1) {
              dfs(A, i, n-1, m, n);
          }
      }
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (A[i][j] == 1) {
                  res++;
              }
          }
      }
      return res;
  }
  
  private void dfs(int[][] M, int r, int c, int h, int w) {
      if ((0 <= r) && (r < h) && (0 <= c) && (c < w)) {
          if (M[r][c] == 1) {
              M[r][c] = -1;
              dfs(M, r + 1, c, h, w);
              dfs(M, r - 1, c, h, w);
              dfs(M, r, c + 1, h, w);
              dfs(M, r, c - 1, h, w);
          }
      }
  }
}