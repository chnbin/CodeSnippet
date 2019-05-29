import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public String frequencySort(String s) {
      if (s == null || s.length() == 0) { return ""; }
      Map<Character, Integer> map = new HashMap<>();
      StringBuilder res = new StringBuilder();
      
      for (char c: s.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
      }
      
      PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> (b.getValue() - a.getValue()));
      
      for (Map.Entry pairs: map.entrySet()) {
          maxHeap.offer(pairs);
      }
      
      while (!maxHeap.isEmpty()) {
          Map.Entry entry = maxHeap.poll();
          System.out.println(entry.getKey());
          char c = (char)entry.getKey();
          int counter = (int)entry.getValue();
          res.append(buildString(c, counter));
      }
      return res.toString();
  }
  
  private String buildString(char c, int counter) {
      String res = "";
      for (int i = 0; i < counter; i++) {
          res += c;
      }
      return res;
  }
}