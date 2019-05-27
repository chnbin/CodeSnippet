import java.util.PriorityQueue;

class Solution {
  public int nthUglyNumber(int n) {
      if (n == 0) { return 0; }
      PriorityQueue<Long> minHeap = new PriorityQueue<>();
      minHeap.offer(1L);
      
      for (int i = 1; i < n; i++) {
          long minValue = minHeap.poll();
          
          while (!minHeap.isEmpty() && minHeap.peek() == minValue) {
              minHeap.poll();
          }
          minHeap.offer(2 * minValue);
          minHeap.offer(3 * minValue);
          minHeap.offer(5 * minValue);
      }
      
      return minHeap.peek().intValue();
  }
}