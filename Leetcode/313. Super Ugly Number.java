import java.util.PriorityQueue;

class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
      if (n == 0) { return 0; }
      PriorityQueue<Long> minHeap = new PriorityQueue<>();
      minHeap.offer(1L);
      
      for (int i = 1; i < n; i++) {
          long minValue = minHeap.poll();
          while (!minHeap.isEmpty() && minHeap.peek() == minValue) {
              minHeap.poll();
          }
          for (int prime: primes) {
              minHeap.offer(minValue * prime);
          }
      }
      
      return minHeap.peek().intValue();
  }
}