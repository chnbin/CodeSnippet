class Solution {
  public boolean validTree(int n, int[][] edges) {
      int[] group = new int[n];
      
      for (int i = 0; i < group.length; i++) {
          group[i] = i;
      }
      
      for (int[] edge: edges) {
          int u = edge[0];
          int v = edge[1];
          int uId = group[u];
          int vId = group[v];
          
          if (uId == vId) {
              return false;
          } else {
              for (int i = 0; i < group.length; i++) {
                  if (group[i] == uId) { group[i] = vId; }
              }
          }
      }
      
      for (int i = 0; i < group.length - 1; i++) {
          if (group[i] != group[i+1]) { return false; }
      }
      return true;
  }
}