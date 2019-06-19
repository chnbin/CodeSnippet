class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
      int pre = 0;
      int next = 0;
      int res = 0;
      
      for (int i = 0; i < flowerbed.length; i++) {
          pre = (i == 0) ? 0 : flowerbed[i-1];
          next = (i == flowerbed.length - 1) ? 0 : flowerbed[i+1];
          
          if (flowerbed[i] == 0 && pre == 0 && next == 0) {
              flowerbed[i] = 1;
              res++;
          }
      }
      return res >= n;
  }
}