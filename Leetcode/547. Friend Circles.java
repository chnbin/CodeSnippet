import java.util.HashSet;
import java.util.Set;

class Solution {
  public int findCircleNum(int[][] M) {
      int n = M.length;
      int[] group = new int[n];
      
      for (int i = 0; i < n; i++) {
          group[i] = i;
      }
      
      for (int i = 0; i < n; i++) {
          for (int j = i; j < n; j++) {
              if (i != j && M[i][j] == 1) {
                  int pId = group[i];
                  int qId = group[j];
              
                  if (pId != qId) {
                      for (int k = 0; k < group.length; k++) {
                          if (group[k] == pId) {
                              group[k] = qId;
                          }
                      }
                  }
              }
          }
      }
      
      Set<Integer> set = new HashSet<>();
      for (int id: group) {
          set.add(id);
      }
      return set.size();
  }
}