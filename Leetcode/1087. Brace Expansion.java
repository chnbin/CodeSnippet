import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public String[] expand(String S) {
      boolean isBrace = false;
      List<Character> tmp = new LinkedList<>();
      Queue<String> queue = new LinkedList<>();
      queue.offer("");
      
      for (char c: S.toCharArray()) {
          if (c == '{') {
              isBrace = true;
              tmp = new LinkedList<>();
          } else if (c == '}') {
              isBrace = false;
              queue = getQueue(queue, tmp);
              tmp = new LinkedList<>();
          } else {
              if (c != ',') {
                  if (isBrace) {
                      tmp.add(c);
                  } else {
                      List<Character> oneChar = new LinkedList<>();
                      oneChar.add(c);
                      queue = getQueue(queue, oneChar);
                  }
              }
          }
      }
      
      String[] res = new String[queue.size()];
      int pos = 0;
      while (!queue.isEmpty()) {
          res[pos++] = queue.poll();
      }
      Arrays.sort(res);

      return res;        
  }
  
  private Queue<String> getQueue(Queue<String> q, List<Character> list) {
      Queue<String> queue = new LinkedList<>();
      
      while (!q.isEmpty()) {
          String tmp = q.poll();
          for (int i = 0; i < list.size(); i++) {
              queue.offer(tmp + list.get(i));
          }
      }
      return queue;
  }
}