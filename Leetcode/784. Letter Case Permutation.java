import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<String> letterCasePermutation(String S) {
      if (S == null || S.length() == 0) { return new ArrayList<>(); }
      List<String> res = new ArrayList<>();
      Queue<String> queue = new LinkedList<>();
      
      queue.offer("");
      
      while (!queue.isEmpty()) {
          String s = queue.poll();

          if (s.length() == S.length()) {
              res.add(s);
              continue;
          }
          char c = S.charAt(s.length());
          if (!Character.isDigit(c)) {
              queue.offer(s + Character.toLowerCase(c));
              queue.offer(s + Character.toUpperCase(c));
          } else {
              queue.offer(s + c);
          }
      }
      return res;
  }
}