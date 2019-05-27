import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
  public int minMeetingRooms(int[][] intervals) {
      if (intervals == null || intervals.length == 0) {
          return 0;
      }
      Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
      PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
      minHeap.offer(intervals[0][1]);
      
      for (int i = 1; i < intervals.length; i++) {
          int endTime = minHeap.peek();
          if (intervals[i][0] < endTime) {
              minHeap.offer(intervals[i][1]);
          } else {
              minHeap.poll();
              minHeap.offer(intervals[i][1]);
          }
      }
      return minHeap.size();
  }
}