class Solution {
  public int[] findRedundantConnection(int[][] edges) {
      // Union-Find
      // This can be improved by quick union, weighted-union, compressed path
      int[] group = new int[edges.length + 1];
      
      for (int i = 0; i < group.length; i++) {
          group[i] = i;
      }
      
      int[] res = new int[2];
      
      for (int[] edge: edges) {
          int u = edge[0];
          int v = edge[1];
          int uId = group[u];
          int vId = group[v];
          
          if (uId == vId) {
              res[0] = u;
              res[1] = v;
              return res;
          } else {
              for (int i = 1; i < group.length; i++) {
                  if (group[i] == uId) {
                      group[i] = vId;
                  }
              }
          }
      }
      return res;
  }
}