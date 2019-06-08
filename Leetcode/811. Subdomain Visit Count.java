import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {
      List<String> res = new ArrayList<>();
      if (cpdomains == null || cpdomains.length == 0) {
          return res;
      }
      Map<String, Integer> map = new HashMap<>();
      
      for (String cpddomain: cpdomains) {
          int count = Integer.parseInt(cpddomain.split(" ")[0]);
          String domain = cpddomain.split(" ")[1];
          
          while (domain.length() > 0) {
              if (!map.containsKey(domain)) {
                  map.put(domain, 0);
              }
              map.put(domain, map.get(domain) + count);
              int index = domain.indexOf(".");
              if (index == -1) {
                  domain = "";
              } else {
                  domain = domain.substring(index+1, domain.length());
              }
          }
      }
      
      for (String key: map.keySet()) {
          res.add(map.get(key) + " " + key);
      }
      return res;
  }
}