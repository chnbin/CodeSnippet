class Solution {
  public int[][] diagonalSort(int[][] mat) {
      int m = mat.length;
      int n = mat[0].length;
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              int x = i;
              int y = j;
              List<Integer> ans = new ArrayList<>();
              
              while (x < m && y < n) {
                  ans.add(mat[x][y]);
                  x++;
                  y++;
              }
              
              Collections.sort(ans);
              x = i;
              y = j;
              int k = 0;
              
              while (k < ans.size()) {
                  mat[x][y] = ans.get(k);
                  k++;
                  x++;
                  y++;
              }
          }
      }
      
      return mat;
  }
}
