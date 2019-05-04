class Solution {
  public boolean isOneBitCharacter(int[] bits) {
      int end = 0;
      int len = bits.length;
      
      while (end < len-1) {
          if (bits[end] == 1) {
              end += 2;
          } else {
              end++;
          }
      }
      
      return end == len-1;
  }
}