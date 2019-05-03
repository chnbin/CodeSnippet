class Solution {
  public int[] numberOfLines(int[] widths, String S) {
      int line = 1;
      int lineSize = 100;
      int[] res = new int[2];

      for (char c: S.toCharArray()){
          int nowSize = widths[c - 'a'];
          if (lineSize >= nowSize) {
              lineSize -= nowSize;
              if (lineSize == 0) {
                  line++;
                  lineSize = 100;
              }
          } else {
              line++;
              lineSize = 100 - nowSize;
          }
      }
      res[0] = line;
      res[1] = 100 - lineSize;
      return res;
  }
}