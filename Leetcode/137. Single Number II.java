public class 137. Single Number II {
  
}class Solution {
  public int singleNumber(int[] nums) {
      /*
          對於XOR的理解多一個，就是不進位加法。
          因此我們要去想對於一個整數n，若n XOR n = 0，
          在這種情況下，我們就是要找一個操作符號？使得n ? n ? n = 0
          看[1,1,1,3]的情況：
          0001
          0001
          0001
          0101
          對於每一位，我們先看他1的個數，然後對其取模3。
          得到0101
      */
      if (nums.length == 1) { return nums[0]; }
      int res = 0;
      
      for (int i = 0; i < 32; i++) {
          int sum = 0;
          for (int num: nums) {
              sum += ((num >> i) & 1);
          }
          sum %= 3;
          res = res | (sum << i);
      }
      
      return res;
  }
}
