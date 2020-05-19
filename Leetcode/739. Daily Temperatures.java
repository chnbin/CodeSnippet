/*
  Monotonic stack, this problem is very similar with Problem 901. Online Stock Span.
 */

class Solution {
  public int[] dailyTemperatures(int[] T) {
      int n = T.length;
      int[] res = new int[n];
      LinkedList<DayInfo> stack = new LinkedList<>();
      
      for (int i = 0; i < n; i++) {
          while (!stack.isEmpty() && T[i] > stack.peek().temperature) {
              DayInfo dayInfo = stack.pop();
              res[dayInfo.idx] = i - dayInfo.idx;
          }
          
          stack.push(new DayInfo(T[i], i));
      }
      
      return res;
  }
  
  private class DayInfo {
      public int temperature;
      public int idx;
      DayInfo(int temperature, int idx) {
          this.temperature = temperature;
          this.idx = idx;
      }
  }
}
