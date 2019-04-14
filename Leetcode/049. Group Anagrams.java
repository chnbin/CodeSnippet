import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
      if (strs == null || strs.length == 0) {
          return new ArrayList<List<String>>();
      }
      
      Map<String, List<String>> table = new HashMap<String, List<String>>();
      
      for(String str: strs) {
          char[] s = str.toCharArray();
          Arrays.sort(s);
          String group = String.valueOf(s);
          
          if (!table.containsKey(group)) {
              table.put(group, new ArrayList<String>());
          } 
          table.get(group).add(str);
      }
      
      return new ArrayList<List<String>>(table.values());
  }
}