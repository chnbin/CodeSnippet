class Solution {
  public int findNumbers(int[] nums) {
      int res = 0;
      
      for (int num: nums) {
          if (digitOfNum(num) % 2 == 0) {
              res++;
          }
      }
      
      return res;
  }
  
  private int digitOfNum(int num) {
      int res = 0;
      
      while (num > 0) {
          res++;
          num /= 10;
      }
      
      return res;
  }
}