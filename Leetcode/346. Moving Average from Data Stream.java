import java.util.LinkedList;

class MovingAverage {
  LinkedList<Integer> list;
  int maxSize;
  double sum;

  /** Initialize your data structure here. */
  public MovingAverage(int size) {
      list = new LinkedList<Integer>();
      maxSize = size;
      sum = 0.0;
  }
  
  public double next(int val) {
      if (list.size() == maxSize) {
          sum -= list.remove();
      }
      sum += val;
      list.add(val);
      return (sum / list.size());
  }
}