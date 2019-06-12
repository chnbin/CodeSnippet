import java.util.Arrays;

class Solution {
  public int findUnsortedSubarray(int[] nums) {
      /* 2 6 4 8 10 9 15
         2 4 6 8 9 10 15 <= sorted nums
           ^ ^   ^  ^ 
           |        |
         Leftmost and rightmost index
      */
      int len = nums.length;
      int[] copy = new int[len];
      
      for (int i = 0; i < len; i++) {
          copy[i] = nums[i];
      }
      
      Arrays.sort(copy);
      int left = 0;
      int leftmostUnsortedIndex = -1;
      int right = len - 1;
      int rightmostUnsortedIndex = -1;
      
      while (left < len) {
          if (nums[left] != copy[left]) {
              leftmostUnsortedIndex = left;
              break;
          }
          left++;
      }
      
      while (right > 0) {
          if (nums[right] != copy[right]) {
              rightmostUnsortedIndex = right;
              break;
          }
          right--;
      }

      if (left == len && right == 0) {
          return 0;
      } else {
          return right - left + 1;
      }
  }
}