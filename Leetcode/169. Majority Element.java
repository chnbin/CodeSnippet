class Solution {
  public int majorityElement(int[] nums) {
      int candicate = 0;
      int counter = 0;
      
      for(int num: nums) {
          if (counter == 0) {
              candicate = num;
              counter = 1;
              continue;
          }
          
          if (num == candicate) {
              counter += 1;
          } else {
              counter -= 1;
          }
      }
      return candicate;
  }
}