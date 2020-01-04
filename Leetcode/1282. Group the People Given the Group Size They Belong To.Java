class Solution {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
      List<List<Integer>> res = new ArrayList<>();
      Map<Integer, List<Integer>> map = new HashMap<>();
      
      for (int i = 0; i < groupSizes.length; i++) {
          List<Integer> tmpList = new ArrayList<>();
          
          if (map.containsKey(groupSizes[i])) {
              tmpList = map.get(groupSizes[i]);
              tmpList.add(i);
          } else {
              tmpList.add(i);
              map.put(groupSizes[i], tmpList);
          }
          
          if (tmpList.size() == groupSizes[i]) {
              res.add(tmpList);
              map.remove(groupSizes[i]);
          }
      }
      
      return res;
  }
}