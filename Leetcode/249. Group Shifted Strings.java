import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
  public List<List<String>> groupStrings(String[] strings) {
      HashMap<String, List<String>> map = new HashMap<String, List<String>>();
      List<List<String>> result = new ArrayList<List<String>>();

      for (String str: strings) {
          StringBuffer s = new StringBuffer();
          for (int i = 1; i < str.length(); i++) {
              // 考慮一下 'ab' 'za'這種狀況
              int shift = ((int)((char)str.charAt(i) - 'a') - 
                           (int)((char)str.charAt(i - 1) - 'a') + 26)%26;
              s.append(String.valueOf(shift));
          }
          
          List<String> tmp = new ArrayList<String>();
          if (map.containsKey(s.toString())) {
              tmp = map.get(s.toString());
              tmp.add(str);
              map.put(s.toString(), tmp);
          } else {
              tmp.add(str);
              map.put(s.toString(), tmp);
          }
      }

      for (List<String> group: map.values()) {
          result.add(group);
      }
      return result;
  }
}