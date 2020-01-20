class RandomizedCollection {
  List<Entry> list;
  Map<Integer, List<Entry>> map;
  java.util.Random rand;
  /** Initialize your data structure here. */
  public RandomizedCollection() {
      list = new ArrayList<>();
      map = new HashMap<>();
      rand = new java.util.Random();
  }
  
  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  public boolean insert(int val) {
      Entry e = new Entry(val, list.size());
      List<Entry> llist = map.getOrDefault(val, new ArrayList<Entry>());
      llist.add(e);
      map.put(val, llist);
      list.add(e);
      return llist.size() == 1;
  }
  
  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
      if (!map.containsKey(val)) {
          return false;
      }
      List<Entry> llst = map.get(val);
      Entry toRemove = llst.get(llst.size() - 1);
      llst.remove(llst.size() - 1);
      Entry last = list.get(list.size() - 1);
      last.index = toRemove.index;
      list.set(toRemove.index, last);
      list.remove(list.size() - 1);
      if (llst.size() == 0) { map.remove(val); }
      return true;
  }
  
  /** Get a random element from the collection. */
  public int getRandom() {
      if (map.size() == 0) { return -1; }
      return list.get(rand.nextInt(list.size())).val;
  }
}

class Entry {
  public int val;
  public int index;
  public Entry(int val, int index) {
      this.val = val;
      this.index = index;
  }
}

/**
* Your RandomizedCollection object will be instantiated and called as such:
* RandomizedCollection obj = new RandomizedCollection();
* boolean param_1 = obj.insert(val);
* boolean param_2 = obj.remove(val);
* int param_3 = obj.getRandom();
*/