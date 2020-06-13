class Solution {
  // Time complexity: O(n^2) where n is the length of prices.
  // To use monotonic stack to improve time complexity to O(n).
  public int[] finalPrices(int[] prices) {
      int n = prices.length;
      for (int i = 0; i < n; i++) {
          for (int j = i + 1; j < n; j++) {
              if (prices[i] >= prices[j]) {
                  prices[i] -= prices[j];
                  break;
              }
          }
      }
      return prices;
  }
}
