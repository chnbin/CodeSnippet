class Solution {
  public int arrangeCoins(int n) {
      return (int) (Math.pow((long)n*2 + 0.25, 0.5) - 0.5);
  }
}