class Solution {
  public int[] findPermutation(String s) {
      /*
          觀察大法：
          其實看全部有幾個數字，然後排好他。
          然後觀察一下s，連續有D的部分全部翻轉。
      */
      int n = s.length();
      int[] res = new int[n+1];
      
      for (int i = 0; i <= n; i++) {
          res[i] = i + 1;
      }
      
      for (int h = 0; h < n; h++) {
          if (s.charAt(h) == 'D') {
              int l = h;
              while (h < n && s.charAt(h) == 'D') h++;
              reverseIntArr(res, l, h); 
          }   
      }  
      
      return res;
  }
  
  private void reverseIntArr(int[] arr, int x, int y) {
      while (x < y) {
          int tmp = arr[x];
          arr[x] = arr[y];
          arr[y] = tmp;
          x++;
          y--;
      }
  }
}