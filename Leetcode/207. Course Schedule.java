import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      int[] inDegree = new int[numCourses];
      Map<Integer, ArrayList<Integer>> g = new HashMap<Integer, ArrayList<Integer>>();
      
      for (int i = 0; i < numCourses; i++) {
          g.put(i, new ArrayList<Integer>());
      }
      
      for (int[] pre: prerequisites) {
          inDegree[pre[0]]++;
          g.get(pre[1]).add(pre[0]);
      }
      Queue<Integer> queue = new LinkedList<>();
      
      for (int i = 0; i < inDegree.length; i++) {
          if (inDegree[i] == 0) {
              queue.offer(i);
          }
      }
      
      Set<Integer> set = new HashSet<>();
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          
          for (int i = 0; i < size; i++) {
              int v = queue.poll();
              set.add(v);
              for (int w: g.get(v)) {
                  inDegree[w]--;
                  if (inDegree[w] == 0) {
                      queue.offer(w);
                  }
              }
          }
      }
      return set.size() == numCourses;
  }
}