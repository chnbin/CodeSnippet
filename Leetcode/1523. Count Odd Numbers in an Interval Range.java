class Solution {
  public int countOdds(int low, int high) {
      int res = 0;
      if ((low % 2) == 1) {
          res++;
          low++;
      }
      
      if ((high % 2) == 1) {
          res++;
          high--;
      }
      
      return res + (int)((high - low) / 2);
  }
}
