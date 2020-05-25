class Solution {
  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
      List<Integer> res = new ArrayList<>();
      Map<Integer, HashSet<String>> map = new HashMap<>();
      
      for (int i = 0; i < favoriteCompanies.size(); i++) {
          map.put(i, new HashSet(favoriteCompanies.get(i)));
      }
      
      for (int i = 0; i < favoriteCompanies.size(); i++) {
          List<String> companies = favoriteCompanies.get(i);
          
          boolean isFound = false;
          
          for (int key: map.keySet()) {
              if (key != i) {
                  HashSet<String> set = map.get(key);
                  
                      if (set.containsAll(companies)) {
                          isFound = true;
                          break;
                      }
                  
              }
          }
          
          if (!isFound) { res.add(i); }
      }
      
      return res;
  }
}
