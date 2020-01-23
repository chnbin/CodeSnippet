class Solution {
  public List<List<String>> findDuplicate(String[] paths) {
      List<List<String>> res = new ArrayList<>();
      Map<String, List<String>> map = new HashMap<>();
      
      for (String path: paths) {
          String[] pathElement = path.split(" ");
          String dir = pathElement[0];
          
          for (int i = 1; i < pathElement.length; i++) {
              int idx = pathElement[i].indexOf("(");
              String value = pathElement[i].substring(idx + 1, pathElement[i].length() - 1);
              map.put(value, map.getOrDefault(value, new ArrayList<String>()));
              map.get(value).add(dir + "/" + pathElement[i].substring(0, idx));
          }
      }
      
      for (String key: map.keySet()) {
          List<String> ans = new ArrayList<>();
          
          for (int i = 0; i < map.get(key).size(); i++) {
              if (map.get(key).size() == 1) { continue; }
              ans.add(map.get(key).get(i));
          }
          if (ans.size() > 1) {
              res.add(ans);
          }
      }
      
      return res;
  }
}