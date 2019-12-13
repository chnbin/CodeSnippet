class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
      
      int[] lastInterval = {Integer.MIN_VALUE, Integer.MIN_VALUE};
      int res = 0;
      
      for (int i = 0; i < intervals.length; i++) {
          if (intervals[i][0] < lastInterval[1]) {
              res++;
          } else {
              lastInterval = intervals[i];
          }
      }
      
      return res;
  }
}