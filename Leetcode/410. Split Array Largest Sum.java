class Solution {
  public int splitArray(int[] nums, int m) {
      // nums 可以切的範圍是1 - n
      // 如果是1，代表整個nums是一塊，故largest sum 是 nums 的總和 -> high
      // 如果是n，代表nums被分成n塊，故largest sum是nums的最大元素 -> low
      int low = 0;
      int high = 0;
      
      for (int num: nums) {
          low = Math.max(low, num);
          high += num;
      }
      
      while (low <= high) {
          int mid = low + (high - low) / 2;
          
          int pieces = split(nums, mid);
          
          if (pieces > m) {
              // 分出太多塊了，代表largest sum應該大一點
              low = mid + 1;
          } else {
              // 分出太少塊了，代表largest sum應該大一點
              high = mid - 1;
          }
      }
      return low;
  }
  
  // 在largestSum為 largestSum 的狀態下，可以切成幾塊
  private int split(int[] nums, int largestSum) {
      int res = 1;
      int currSum = 0;
      
      for (int num: nums) {
          if (currSum + num > largestSum) {
              res++;
              currSum = num;
          } else {
              currSum += num;
          }
      }
      
      return res;
  }
}