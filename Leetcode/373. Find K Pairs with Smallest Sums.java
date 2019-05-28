import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> (a[0]+a[1]-b[0]-b[1]));
      
      for (int num1: nums1) {
          for (int num2: nums2) {
              int[] pair = {num1, num2};
              minHeap.offer(pair);
          }
      }
      int size = (minHeap.size() < k) ? minHeap.size() : k;
      
      for (int i = 0; i < size; i++) {
          List<Integer> tmp = new ArrayList<Integer>();
          int[] pair = minHeap.poll();
          tmp.add(pair[0]);
          tmp.add(pair[1]);
          res.add(tmp);
      }
      return res;
  }
}