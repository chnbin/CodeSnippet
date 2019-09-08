import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
  public int numSquares(int n) {
      List<Integer> queue = new LinkedList<>();
      List<Integer> squares = new ArrayList<>();
      
      for (int i = 1; i*i <= n; i++) {
          squares.add(i*i);
      }
      queue.add(0);
      int level = 1;
      
      while (true) {
          Set<Integer> set = new HashSet<>();
          
          for (int i = 0; i < queue.size(); i++) {
              for (int j = 0; j < squares.size(); j++) {
                  int c = queue.get(i) + squares.get(j);
                  
                  if (c == n) {
                      return level;
                  } else {
                      set.add(c);
                  }
              }
          }
          level++;
          queue = new LinkedList(set);
      }
      
  }
}