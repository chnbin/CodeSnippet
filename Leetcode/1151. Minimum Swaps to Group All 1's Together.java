class Solution {
  public int minSwaps(int[] data) {
      int k = 0; // Window's width
      
      for (int num: data) { if (num == 1) { k++; } }
      if (k == 1) { return 0; }
      int swap = Integer.MAX_VALUE;
      
      int cnt1 = 0;
      int cnt0 = 0;
      
      for (int i = 0; i < k; i++) {
          if (data[i] == 1) {
              cnt1++;
          } else {
              cnt0++;
          }
      }
      swap = Math.min(swap, Math.abs(k - cnt1));
      
      for (int i = k; i < data.length; i++) {
          if (data[i] == 1) {
              cnt1++;
          } else {
              cnt0++;
          }
          
          if (data[i-k] == 1) {
              cnt1--;
          } else {
              cnt0--;
          }
          swap = Math.min(swap, Math.abs(k - cnt1));
      }
      return swap;
  }         
}