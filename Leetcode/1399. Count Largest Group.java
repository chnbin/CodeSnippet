class Solution {
  public int countLargestGroup(int n) {
      int[] table = new int[37];
      int maxCnt = 0;
      int res = 0;
      
      for (int i = 1; i <= n; i++) {
          int sum = sumOfDigit(i);
          table[sum]++;
          maxCnt = Math.max(maxCnt, table[sum]);
      }
      
      for (int cnt: table) {
          if (cnt == maxCnt) {
              res++;
          }
      }
      
      return res;
  }
  
  private int sumOfDigit(int n) {
      int res = 0;
      
      while (n > 0) {
          res += (n % 10);
          n /= 10;
      }
      
      return res;
  }
}