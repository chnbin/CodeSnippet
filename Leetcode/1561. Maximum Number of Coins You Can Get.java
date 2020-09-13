class Solution {
  public int maxCoins(int[] piles) {
      int res = 0;
      
      Arrays.sort(piles);
      
      int m = piles.length / 3;
      int n = piles.length - 2;
      
      while (m > 0) {
          res += piles[n];
          n -= 2;
          m--;
      }
      
      return res;
  }
}
