class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int[][] w = new int[n][n];
      
      for (int i = 0; i < n; i++) {
          Arrays.fill(w[i], 100000);
          w[i][i] = 0;
      }
      
      for (int[] edge: edges) {
          w[edge[0]][edge[1]] = Math.min(w[edge[0]][edge[1]], edge[2]);
          w[edge[1]][edge[0]] = Math.min(w[edge[1]][edge[0]], edge[2]);
      }
      
      // Floyd Warshall
      for (int k = 0; k < n; k++) {
          for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                  if (w[i][j] > w[i][k] + w[k][j]) {
                      w[i][j] = w[i][k] + w[k][j];
                  }
              }
          }
      }
      
      int min = Integer.MAX_VALUE;
      int res = -1;
      for (int i = 0; i < n; i++) {
          int canReach = 0;
          for (int j = 0; j < n; j++) {
              if (w[i][j] <= distanceThreshold) {
                  canReach++;
              }
          }
          
          if (canReach <= min) {
              res = i;
              min = canReach;
          }
      }
      
      return res;
  }
}