import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
  public List<String> removeInvalidParentheses(String s) {
      List<String> res = new ArrayList<>();
      if (s == null) { return res; }
      Queue<String> queue = new LinkedList<>();
      queue.offer(s);
      Set<String> visited = new HashSet<>();
      visited.add(s);
      boolean isFound = false;
      
      while (!queue.isEmpty()) {
          String str = queue.poll();
          
          if (isValid(str)) {
              res.add(str);
              isFound = true;
          }
          
          if (isFound) { continue; }
          
          for (int i = 0; i < str.length(); i++) {
              if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                  String candicate = str.substring(0, i) + str.substring(i + 1);
              
                  if (!visited.contains(candicate)) {
                      visited.add(candicate);
                      queue.offer(candicate);
                  }
              }
          }
      }
      
      return res;
  }
  
  private boolean isValid(String s) {
      int count = 0;
      
      for (char c: s.toCharArray()) {
          if (c == '(') {
              count++;
          } else if (c == ')') {
              if (count-- == 0) {
                  return false;
              }
          }
      }
      return count == 0;
  }
}