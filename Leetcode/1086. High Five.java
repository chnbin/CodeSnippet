import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  private final int SIZE = 5;
  public int[][] highFive(int[][] items) {
      Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
      
      for (int[] item: items) {
          int id = item[0];
          int score = item[1];
          
          if (map.containsKey(id)) {
              PriorityQueue<Integer> minHeap = map.get(id);
              minHeap.offer(score);
              if (minHeap.size() > SIZE) {
                  minHeap.poll();
              }
              map.put(id, minHeap);
          } else {
              PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
              minHeap.offer(score);
              map.put(id, minHeap);
          }
      }
      
      int[][] res = new int[map.keySet().size()][2];
      int pos = 0;
      
      for (int i = 1; i <= 10000; i++) {
          if (map.containsKey(i)) {
              int score = 0;
              PriorityQueue<Integer> minHeap = map.get(i);
              while (!minHeap.isEmpty()) {
                  score += minHeap.poll();
              }
              res[pos][0] = i;
              res[pos][1] = score / 5;
              pos++;
          }
      }
      return res;
  }
}