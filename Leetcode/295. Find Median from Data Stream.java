import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;
  /** initialize your data structure here. */
  public MedianFinder() {
      // Prepare two heap:
      // All elements of minHeap are bigger than all elements of maxHeap.
      // All elements of maxHeap are smaller than all elements of minHeap.
      minHeap = new PriorityQueue<>();
      maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
  }
  
  public void addNum(int num) {
      minHeap.offer(num);
      maxHeap.offer(minHeap.poll());
      if (minHeap.size() < maxHeap.size()) {
          minHeap.offer(maxHeap.poll());
      }
  }
  
  public double findMedian() {
      if (minHeap.size() == maxHeap.size()) {
          return ((maxHeap.peek() + (minHeap.peek())) / 2.0);
      }
      return (minHeap.peek());
  }
}