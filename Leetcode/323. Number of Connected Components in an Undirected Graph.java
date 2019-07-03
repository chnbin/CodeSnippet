import java.util.HashSet;
import java.util.Set;

class Solution {
  public int countComponents(int n, int[][] edges) {
      int[] group = new int[n];
      for (int i = 0; i < group.length; i++) {
          group[i] = i;
      }
      
      for (int[] edge: edges) {
          int u = edge[0];
          int v = edge[1];
          int uId = group[u];
          int vId = group[v];
          
          if (uId != vId) {
              for (int i = 0; i < group.length; i++) {
                  if (group[i] == uId) {
                      group[i] = vId;
                  }
              }
          }            
      }
      
      Set<Integer> set = new HashSet<>();
      
      for (int num: group) { set.add(num); }
      
      return set.size();
  }
}