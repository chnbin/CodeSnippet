class Solution {
  public int thirdMax(int[] nums) {
      // We use long because if test case contains Integer.MIN_VALUE the result will wrong.
      long first = Long.MIN_VALUE;
      long second = Long.MIN_VALUE;
      long third = Long.MIN_VALUE;
      
      for (int num: nums) {
          if (num > first) {
              third = second;
              second = first;
              first = num;
          }
          
          if (num > second && num < first) {
              third = second;
              second = num;
          }
          
          if (num > third && num < second) {
              third = num;
          }
      }
      
      return (third == Long.MIN_VALUE) ? (int)first : (int)third;
  }
}