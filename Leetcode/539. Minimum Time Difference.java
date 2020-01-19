class Solution {
  public int findMinDifference(List<String> timePoints) {
      int n = timePoints.size();
      int[] times = new int[n];
      int res = Integer.MAX_VALUE;
      
      // Compute real time, 00:00 is 0, 23:59 is 1399
      for (int i = 0; i < n; i++) {
          String time = timePoints.get(i);
          times[i] = (Integer.parseInt(time.substring(0, 2)) * 60)
                  + (Integer.parseInt(time.substring(3)));
      }
      
      Arrays.sort(times);
      
      for (int i = 1; i < n; i++) {
          res = Math.min(res, times[i] - times[i - 1]);
      }
      
      // Check cornet case
      res = Math.min(res, 1440 - times[n - 1] + times[0]);
      
      return res;
  }
}