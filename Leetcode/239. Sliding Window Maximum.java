import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
      if (nums == null || nums.length == 0) { return new int[0];}
      if (k == 1) { return nums; }

      List<Integer> list = new ArrayList<>();
      Deque<Integer> deque = new LinkedList<>();
      
      for (int i = 0; i < k; i++) {
          while (!deque.isEmpty()) {
              if (nums[i] > nums[deque.getLast()]) {
                  deque.removeLast();
              } else {
                  break;
              }
          }
          deque.offer(i);
      }
      
      for (int i = k; i < nums.length; i++) {
          list.add(nums[deque.getFirst()]);
          
          if (i - k + 1 > deque.getFirst()) {
              deque.removeFirst();
          }
          
          while (!deque.isEmpty()) {
              if (nums[i] > nums[deque.getLast()]) {
                  deque.removeLast();
              } else {
                  break;
              }
          }
          deque.offer(i);
      }
      
      list.add(nums[deque.removeFirst()]);
      int[] ans = new int[list.size()];
      
      for (int i = 0; i < list.size(); i++) {
          ans[i] = list.get(i);
      }
      return ans;
  }
}