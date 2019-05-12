class Solution {
  public int findComplement(int num) {
      int n = num;
      int mask = 1;
      
      while (n > 0) {
          mask <<= 1;
          n /= 2;
      }
      
      return num^(mask - 1);
  }
}