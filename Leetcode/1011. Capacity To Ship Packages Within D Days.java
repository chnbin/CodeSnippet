class Solution {
  public int shipWithinDays(int[] weights, int D) {
      int left = maxOfArray(weights);
      int right = sumOfArray(weights);
      
      while (left <= right) {
          int mid = (left + right) / 2;
          if (getDDay(weights, mid) <= D) {
              right = mid - 1;
          } else {
              left = mid + 1;
          } 
      }
      /*for (int i = left; i < right+1;i++) {
          int day = getDDay(weights, i);
          System.out.println(i + ": " + day);
      }*/
      return left;
  }
  
  private int maxOfArray(int[] nums) {
      int res = 0;
      for (int num: nums) {
           res = Math.max(res, num);
      }
      return res;
  }
  
  private int sumOfArray(int[] nums) {
      int res = 0;
      for (int num: nums) {
          res += num;
      }
      return res;
  }
  
  private int getDDay(int[] nums, int weight) {
      int days = 1;
      int currWeight = 0;
      for (int num: nums) {
          if (currWeight + num > weight) {
              days += 1;
              currWeight = 0;
          }
          currWeight += num;
      }
      return days;
  }
}