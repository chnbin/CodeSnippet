class Solution {
  public int findDuplicate(int[] nums) {
      int fast = 0;
      int slow = 0;
      
      while (true) {
          fast = nums[fast];
          fast = nums[fast];
          slow = nums[slow];
          
          if (fast == slow) {
              slow = 0;
              break;
          }
      }
      
      while (true) {
          fast = nums[fast];
          slow = nums[slow];
          if (fast == slow) {
              return slow;
          }
      }
      //return -1;
  }
}
