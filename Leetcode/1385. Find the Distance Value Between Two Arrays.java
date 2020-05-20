class Solution {
  /*
    Time complexity: O(NlogN)
    Step 1: Sort arr2.
    Step 2: For each element in arr1, binary search it in arr2. Compare the distance from its neighhours
   */
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
      Arrays.sort(arr2);
      int res = 0;
      
      for (int num: arr1) {
          if (isDistanceValue(arr2, num, d)) {
              res++;
          }
      }
      
      return res;
  }
  
  private boolean isDistanceValue(int[] nums, int target, int k) {
      int left = 0;
      int right = nums.length - 1;
      
      while (left <= right) {
          int mid = left + (right - left) / 2;
          
          if (Math.abs(target - nums[mid]) <= k) {
              return false;
          } else if (target < nums[mid]) {
              right = mid - 1;
          } else {
              left = mid + 1;
          }
      }
      
      
      return true;
  }
}
