class Solution {
  /*
    Counting the frequence of each number.
    Frequence 0 means this number missed.
    Frequence is bigger than 1 means this number occurs twice.
   */
  public int[] findErrorNums(int[] nums) {
      int occurTwice = -1;
      int missing = -1;
      
      int[] table = new int[nums.length];
      
      for (int num: nums) {
          table[num - 1]++;
      }
      
      for (int i = 0; i < table.length; i++) {
          if (table[i] == 0) {
              missing = i + 1;
              continue;
          }
          
          if (table[i] > 1) {
              occurTwice = i + 1;
              continue;
          }
      }
      
      return new int[]{occurTwice, missing};
  }
}
