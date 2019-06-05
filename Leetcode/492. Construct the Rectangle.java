class Solution {
  public int[] constructRectangle(int area) {
      int[] res = new int[2];
      res[0] = 1;
      res[1] = 1;
      
      for (int i = (int)Math.sqrt(area); i >= 1; i--) {
          int w = i;
          if (area % w == 0) {
              int l = area/w;
              res[0] = l;
              res[1] = w;
              break;
          }
      }
      return res; 
  }
}