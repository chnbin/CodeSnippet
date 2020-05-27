class Solution {
  public boolean possibleBipartition(int N, int[][] dislikes) {
      Map<Integer, Set<Integer>> g = new HashMap<>();
      for (int[] dislike: dislikes) {
          int v = dislike[0];
          int w = dislike[1];
          
          if (!g.containsKey(v)) {
              g.put(v, new HashSet<>());
          }
          
          if (!g.containsKey(w)) {
              g.put(w, new HashSet<>());
          }
          
          g.get(v).add(w);
          g.get(w).add(v);
      }
      
      int[] colors = new int[N + 1];
      
      for (int i = 1; i <= N; i++) {
          if (colors[i] == 0 && !dfs(colors, i, 1, g)) {
              return false;
          }
      }
      
      return true;
  }
  
  private boolean dfs(int[] colors, int node, int color, Map<Integer, Set<Integer>> g) {
      if (colors[node] != 0) {
          return colors[node] == color;
      }
      
      colors[node] = color;
      
      if (!g.containsKey(node)) { return true; }
      for (int next: g.get(node)) {
          if (!dfs(colors, next, -color, g)) {
              return false;
          }
      }
      
      return true;
  }
}
