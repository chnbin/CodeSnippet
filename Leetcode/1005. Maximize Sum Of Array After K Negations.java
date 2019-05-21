import java.util.PriorityQueue;

class Solution {
  public int largestSumAfterKNegations(int[] A, int K) {
      PriorityQueue<Integer> heap = new PriorityQueue<>();
      int res = sum(A);
      
      for (int num: A) { heap.offer(num); }
      
      // We pick min value i from heap and replace i to -i.
      // Then put -i to heap.
      while (K > 0) {
          int minValue = heap.poll();
          heap.offer(-minValue);
          // Update new sum
          res += 2*(-minValue);
          K--;
      }
      return res;
  }
  private int sum(int[] nums) {
      int sum = 0;
      for (int num: nums) { sum += num; }
      return sum;
  }
}