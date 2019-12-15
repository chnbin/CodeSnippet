class Solution {
  public int removeCoveredIntervals(int[][] intervals) {
      int res = 0;
      Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
      
      for (int i = intervals.length - 1; i >= 0; i--) {
          int low = intervals[i][0];
          int high = intervals[i][1];
          
          for (int j = 0; j < i; j++) {
              if (low >= intervals[j][0] && intervals[j][1] >= high) {
                  res++;
                  break;
              }
          }
      }
      
      return intervals.length - res;
  }
}