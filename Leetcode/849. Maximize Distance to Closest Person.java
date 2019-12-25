class Solution {
  public int maxDistToClosest(int[] seats) {
      // 用來存0到最近的1的距離，以Example 1為例：
      // 先從左邊算過去：[0, 1, 2, 3, 0, 1, 0]
      // 再從右邊算過去：[0, 1, 2, 1, 0, 1, 0]
      // 答案為最大的2
      int[] dists = new int[seats.length];
      int seat = 20000;
      
      // 從左邊算過去
      for (int i = 0; i < seats.length; i++) {
          if (seats[i] == 1) {
              seat = 1;
          } else {
              dists[i] = seat;
              seat++;
          }
      }
      
      seat = 20000;
      // 從右邊算過去
      for (int i = seats.length - 1; i >=0; i--) {
            if (seats[i] == 1) {
              seat = 1;
          } else {
              dists[i] = Math.min(dists[i], seat);
              seat++;
          }
      }
      
      int res = Integer.MIN_VALUE;
      
      for (int dist: dists) {
          res = Math.max(res, dist);
      }
      
      return res;
  }
}