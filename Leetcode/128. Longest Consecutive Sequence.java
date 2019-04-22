import java.util.HashMap;

class Solution {
  public int longestConsecutive(int[] nums) {
      if (nums == null || nums.length == 0) { return 0; }
      HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
      int maxLen = Integer.MIN_VALUE;
      
      for (int num: nums) {
          if (!dict.containsKey(num)) {
              dict.put(num, 1);
          }
      }
      
      for (int num: nums) {
          int currLen = 1;
          int big = num + 1;
          int small = num - 1;
          dict.put(num, dict.get(num)*(-1));
          
          while (dict.containsKey(big) && dict.get(big) != -1) {
              currLen++;
              dict.put(big, dict.get(big)*(-1));
              big++;
          }
          
          while (dict.containsKey(small) && dict.get(small) != -1) {
              currLen++;
              dict.put(small, dict.get(small)*(-1));
              small--;
          }
          maxLen = Math.max(maxLen, currLen);
      }
      
      return maxLen;
}
}