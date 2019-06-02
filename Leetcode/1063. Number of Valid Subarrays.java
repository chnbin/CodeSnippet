import java.util.LinkedList;

class Solution {
  public int validSubarrays(int[] nums) {
      int res = 0;
      LinkedList<Integer> stack = new LinkedList<>();
      
      for (int num: nums) {
          while (!stack.isEmpty() && num < stack.peek()) {
              stack.pop();
          }
          stack.push(num);
          res += stack.size();
      }
      return res;
  }
}