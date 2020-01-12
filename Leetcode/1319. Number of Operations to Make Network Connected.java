class Solution {
  public int makeConnected(int n, int[][] connections) {
      if (connections.length < n - 1) { return -1; }
      int[] group = new int[n];
      for (int i = 0; i < n; i++) {
          group[i] = i;
      }
      
      for (int[] conn: connections) {
          int p = group[conn[0]];
          int q = group[conn[1]];
          
          for (int i = 0; i < n; i++) {
              if (p != q) {
                  if (group[i] == p) {
                      group[i] = q;
                  }
              }
          }
      }
      Set<Integer> set = new HashSet<>();
      for (int g: group) {
          set.add(g);
      }
      int cntGroup = set.size();
      
      return cntGroup - 1;
  }
}