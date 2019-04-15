import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
      intervals.add(newInterval);
      
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