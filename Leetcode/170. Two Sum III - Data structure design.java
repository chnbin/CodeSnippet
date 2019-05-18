import java.util.HashMap;
import java.util.Map;

class TwoSum {
  Map<Integer, Integer> map;
  /** Initialize your data structure here. */
  public TwoSum() {
      map = new HashMap<>();
  }
  
  /** Add the number to an internal data structure.. */
  public void add(int number) {
      if (!map.containsKey(number)) {
          map.put(number, 0);
      }
      // for corner case add(0), find(0)
      map.put(number, map.get(number) + 1);
  }
  
  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
      for (int num: map.keySet()) {
          if (map.containsKey(value - num)) {
              // for corner case add(0), find(0)
              if ((value - num) == num) {
                  if (map.get(num) > 1) {
                      return true;
                  }
              } else {
                  return true;
              }
          }
      }
      return false;
  }
}