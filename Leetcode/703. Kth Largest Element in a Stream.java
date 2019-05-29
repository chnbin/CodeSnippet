import java.util.PriorityQueue;

class KthLargest {
  /**
   * A size k minHeap, the peek of heap is the kth largest element in
   * a stream.
   */
  PriorityQueue<Integer> minHeap;
  int capacity;
  
  public KthLargest(int k, int[] nums) {
      minHeap = new PriorityQueue<>();
      capacity = k;
      
      for (int num: nums) {
          minHeap.offer(num);
          
          if (minHeap.size() == capacity + 1) {
              minHeap.poll();
          }
      }
  }
  
  public int add(int val) {
      minHeap.offer(val);
      if (minHeap.size() == capacity + 1) {
          minHeap.poll();
      }
      return minHeap.peek();
  }
}

