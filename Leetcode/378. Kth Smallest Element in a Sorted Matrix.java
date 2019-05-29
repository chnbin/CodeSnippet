import java.util.PriorityQueue;

class Solution {
  public int kthSmallest(int[][] matrix, int k) {
      PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
      int res = 0;
      
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[0].length; j++) {
              minHeap.offer(matrix[i][j]);
          }
      }
      
      while (k > 0) {
          res = minHeap.poll();
          k--;
      }
      return res;
  }
}