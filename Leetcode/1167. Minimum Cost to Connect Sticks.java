import java.util.PriorityQueue;

class Solution {
  public int connectSticks(int[] sticks) {
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      
      for (int s: sticks) { pq.offer(s); }
      
      int res = 0;
      
      while (!(pq.size() == 1)) {
          int stick1 = pq.poll();
          int stick2 = pq.poll();
          
          res += (stick1 + stick2);
          pq.offer(stick1 + stick2);
      }
      
      return res;
  }
}