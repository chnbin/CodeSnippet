import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
  public int minimumSemesters(int N, int[][] relations) {
      Set<Integer> visited = new HashSet<>();
      List<List<Integer>> graph = new ArrayList<>();
      Queue<Integer> queue = new LinkedList<>();
      int[] inDegree = new int[N+1];
      
      // Inital graph
      for (int i = 0; i <= N; i++) {
          graph.add(new ArrayList<Integer>());
      }
      
      for (int[] re: relations) {
          int v = re[0];
          int w = re[1];
          graph.get(v).add(w);
          inDegree[w]++;
      }
      
      // Put node into queue if indegree of node is zero
      for (int i = 1; i <= N; i++) {
          if (inDegree[i] == 0) {
              queue.offer(i);
          }
      }
      
      int res = 0;
      
      // Toplogical sort
      while (!queue.isEmpty()) {
          int size = queue.size();
          for (int i = 0; i < size; i++) {
              int node = queue.poll();
              visited.add(node);
              for (int target: graph.get(node)) {
                  inDegree[target]--;
                  if (inDegree[target] == 0) {
                      queue.add(target);
                  }
              }
          }
          
          res++;
      }
      
      if (visited.size() != N) {
          res = -1;
      }
      return res;
  }
}