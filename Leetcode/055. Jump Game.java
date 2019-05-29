class Solution {
  public boolean canJump(int[] nums) {
      if (nums == null || nums.length == 0) { return true; }
      /**
       * 1. To initialize canReachPos with 0, this variable record
       *    the farthest position can reach.
       * 2. To traverse nums, compare canReachPos with index. If canReachPos
       *    bigger than the index to update canReach.
       */
      int lastPos = nums.length - 1;
      int canReachPos = 0;
      
      for (int i = 0; i <= lastPos; i++) {
          if (canReachPos < i) {
              break;
          }
          canReachPos = Math.max(canReachPos, i + nums[i]);
      }
      return (canReachPos >= lastPos);
  }
}