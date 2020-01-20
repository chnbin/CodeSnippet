class RandomizedSet {
  private int cnt; // size of list
  private List<Integer> list;
  private Map<Integer, Integer> map;
  private java.util.Random rand;

  /** Initialize your data structure here. */
  public RandomizedSet() {
      cnt = 0;
      list = new ArrayList<>();
      map = new HashMap<>();
      rand = new java.util.Random();
  }
  
  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
      if (map.containsKey(val)) { return false; }
      cnt++;
      list.add(val);
      map.put(val, cnt - 1);
      return true;
  }
  
  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
      if (!map.containsKey(val)) { return false; }
      int idx = map.get(val);
      int lastElement = list.get(cnt - 1);
      list.set(idx, lastElement);
      map.put(lastElement, idx);
      list.remove(cnt - 1);
      map.remove(val);
      cnt--;
      return true;
  }
  
  /** Get a random element from the set. */
  public int getRandom() {
      return list.get(rand.nextInt(cnt));
  }
}

/**
* Your RandomizedSet object will be instantiated and called as such:
* RandomizedSet obj = new RandomizedSet();
* boolean param_1 = obj.insert(val);
* boolean param_2 = obj.remove(val);
* int param_3 = obj.getRandom();
*/