class Solution {
  public int[][] mergeInterval(int[][] intervals) {
      List<Interval> interval = new LinkedList<>();
      if (intervals.length <= 1) { return intervals; }
      
      for (int[] i:intervals) {
          interval.add(new Interval(i[0], i[1]));
      }
      
      interval.sort((i1, i2) -> (i1.start - i2.start));
      
      LinkedList<Interval> stack = new LinkedList<>();
      
      for (int i = 0; i < interval.size(); i++) {
          if (stack.size() == 0) {
              stack.push(interval.get(i));
          } else {
              if (interval.get(i).start > stack.peek().end){
                  stack.push(interval.get(i));
              } else {
                  stack.peek().end = Math.max(stack.peek().end, interval.get(i).end);
              }
          }
      }
      
      int[][] res = new int[stack.size()][2];
      
      for (int i = 0; i < stack.size(); i++) {
          res[stack.size() - 1 - i][0] = stack.get(i).start;
          res[stack.size() - 1 - i][1] = stack.get(i).end;
      }
      
      return res;
  }
}

class Interval {
  int start;
  int end;
  Interval(int start, int end) {
      this.start = start;
      this.end = end;
  }
}