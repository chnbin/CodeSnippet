import java.util.HashMap;
import java.util.Map;

class MyHashSet {
  private final int MAP_VALUE = 1;
  private Map<Integer, Integer> set;
  
  /** Initialize your data structure here. */
  public MyHashSet() {
      set = new HashMap<>();
  }
  
  public void add(int key) {
      set.put(key, MAP_VALUE);
  }
  
  public void remove(int key) {
      if (set.containsKey(key)) {
          set.remove(key);
      }
  }
  
  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
      return set.containsKey(key);
  }
}

