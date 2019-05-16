import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      if (nums1 == null || nums1.length == 0) { return new int[0]; }
      int[] res = new int[nums1.length];
      LinkedList<Integer> stack = new LinkedList<>();
      Map<Integer, Integer> map = new HashMap<>();
      
      // nums2 = [4, 3, 2, 5]
      for (int num: nums2) {
          // If num is greater than the top element of stack,
          // num is next greater element of the top element of stack.
          while (!stack.isEmpty() && stack.peek() < num) {
              map.put(stack.pop(), num);
          }
          stack.push(num);
      }
      
      for (int i = 0; i < nums1.length; i++) {
          res[i] = map.getOrDefault(nums1[i], -1);
      }
      return res;
  }
}