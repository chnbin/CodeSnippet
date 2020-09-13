class Solution {
  public boolean threeConsecutiveOdds(int[] arr) {
      if (arr == null || arr.length < 3) {
          return false;
      }
      
      int n = arr.length;
      
      for (int i = 2; i < n; i++) {
          if ((arr[i] % 2 == 1) && (arr[i - 1] % 2 == 1) && (arr[i - 2] % 2 == 1)) {
              return true;
          }
      }
      
      return false;
  }
}
