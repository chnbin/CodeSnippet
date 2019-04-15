import java.util.LinkedList;
import java.util.List;
class Interval { int start; int end;
 Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end = e; }
}
 
class Solution {
  public List<Interval> merge(List<Interval> intervals) {
      if (intervals.size() <= 1) { return intervals; }
      
      // Sort by ascending starting point
      intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
      
      LinkedList<Interval> stack = new LinkedList<Interval>();
      
      for (Interval interval: intervals) {
          if (stack.size() == 0) {
              stack.add(interval);
          } else {
              if (interval.start > stack.peekLast().end) {
                  stack.add(interval);
              } else {
                  stack.peekLast().end = Math.max(stack.peekLast().end, interval.end);
              }
          }
      }
      return stack;
  }
}