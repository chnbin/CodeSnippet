class Solution {
  public int oddCells(int n, int m, int[][] indices) {
      int[] rows = new int[n];
      int[] cols = new int[m];
      int res = 0;
      
      for (int[] index: indices) {
          rows[index[0]]++;
          cols[index[1]]++;
      }
      
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              res =  ((rows[i] + cols[j]) % 2 == 0) ? res : res + 1;
          }
      }
      return res;
  }
}