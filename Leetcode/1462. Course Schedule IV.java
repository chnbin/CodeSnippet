class Solution {
  public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
      List<Boolean> res = new ArrayList<>();
      Map<Integer, ArrayList<Integer>> g = new HashMap<>();
      
      for (int i = 0; i < n; i++) {
          g.put(i, new ArrayList<Integer>());
      }
      
      for (int[] pre: prerequisites) {
          g.get(pre[0]).add(pre[1]);
      }
      
      for (int[] query: queries) {
          int v = query[0];
          int w = query[1];
          boolean[] visited = new boolean[n];
          
          boolean isFound = false;
          
          if (g.get(w) != null) {
              Queue<Integer> q = new LinkedList<>();
              q.offer(v);
              visited[v] = true;
              
              while (!q.isEmpty()) {
                  if (isFound) { break; }
                  int size = q.size();
                  
                  for (int i = 0; i < size; i++) {
                      int node = q.poll();
                      if (node == w) {
                          isFound = true;
                          break;
                      }
                      
                      for (int next: g.get(node)) {
                          if (!visited[next]) {
                              q.offer(next);
                              visited[next] = true;
                          }
                      }
                  }
              }
          }
          res.add(isFound);
      }
      
      return res;
  }
  
}
