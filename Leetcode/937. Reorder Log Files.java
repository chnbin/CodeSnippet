import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
  public String[] reorderLogFiles(String[] logs) {
      LinkedList<String> list = new LinkedList<>();
      PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
          public int compare(String s1, String s2) {
              int index1 = s1.indexOf(" ");
              int index2 = s2.indexOf(" ");
              String id1 = s1.substring(0, index1);
              String id2 = s2.substring(0, index2);
              String log1 = s1.substring(index1 + 1);
              String log2 = s2.substring(index2 + 1);
              
              if (log1.equals(log2)) {
                  return id2.compareTo(id1);
              }
              return log2.compareTo(log1);
          }
      });
      
      for (String log: logs) {
          String[] parts = log.split(" ");
          if ('0' <= parts[1].charAt(0) && parts[1].charAt(0) <= '9') {
              list.add(log);
          } else {
              pq.offer(log);
          }
      }
      
      while (!pq.isEmpty()) {
          list.addFirst(pq.poll());
      }
      
      String[] res = new String[list.size()];
      
      for (int i = 0; i < list.size(); i++) {
          res[i] = list.get(i);
      }
      
      return res;
  }
}