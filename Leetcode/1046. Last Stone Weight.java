import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
  public int lastStoneWeight(int[] stones) {
      // 1 <= stones.length <= 30
      // if (stones == null || stones.length == 0) { return 0;}
      if (stones.length == 1) { return stones[0]; }
      PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
      
      for (int stone: stones) {
          heap.offer(-1*stone);
      }
      
      while (heap.size() != 1) {
          int first = -1 * heap.poll();
          int second = -1 * heap.poll();
          int remain = Math.abs(first - second);
          heap.offer(-1*remain);
      }
      return -1*heap.poll();
  }

  // Max-heap
  public int lastStoneWeight2(int[] stones) {
    if (stones.length == 1) { return stones[0]; }
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
    
    for (int stone: stones) {
        heap.offer(stone);
    }
    
    while (heap.size() != 1) {
        int first = heap.poll();
        int second = heap.poll();
        int remain = Math.abs(first - second);
        heap.offer(remain);
    }
    return heap.poll();
  }
}
