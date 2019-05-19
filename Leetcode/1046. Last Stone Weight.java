import java.util.PriorityQueue;

class Solution {
  public int lastStoneWeight(int[] stones) {
      if (stones == null || stones.length == 0) { return 0;}
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
}