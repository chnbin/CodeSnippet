class Solution {
  public int minEatingSpeed(int[] piles, int H) {
      int left = 1;//minOfArray(piles);
      int right = maxOfArray(piles);

      while (left <= right) {
          int mid = (left + right) / 2;
          if (needsHoursToEatAll(piles, mid) <= H) {
              //res = mid;
              right = mid - 1;
          } else {
              left = mid + 1;
          }
          
      }
      /*
      for (int i = left; i < right + 1; i++) {
          System.out.println(i + ": " + needsHoursToEatAll(piles, i));
      }*/
      return left;
  }
  
  private int needsHoursToEatAll(int[] piles, int hour) {
      int needs = 0;
      
      for (int pile: piles) {
          needs += (pile / hour);
          if (pile % hour > 0) {
              needs += 1;
          }
      }
      
      return needs;
  }
  
  private int maxOfArray(int[] nums) {
      int res = Integer.MIN_VALUE;
      
      for (int num: nums) {
          res = Math.max(res, num);
      }
      return res;
  }
}