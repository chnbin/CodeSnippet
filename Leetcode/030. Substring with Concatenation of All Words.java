class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> res = new ArrayList<>();
      
      if (words == null || words.length == 0) { return res; }
      Map<String, Integer> map = new HashMap<>();
      int len = words[0].length();
      int totalLen = len * words.length;
      
      for (String word: words) {
          map.put(word, map.getOrDefault(word, 0) + 1);
      }
      
      for (int i = 0; i <= (s.length() - totalLen); i++) {
          Map<String, Integer> tmp = new HashMap<>(map);
          
          for (int j = 0; j < words.length; j++) {
              int startIdx = i + (j * len);
              int endIdx = startIdx + len;
              
              String str = s.substring(startIdx, endIdx);
              
              if (!tmp.containsKey(str)) {
                  break;
              } else {
                  if (tmp.get(str) == 0) {
                      break;
                  } else {
                      tmp.put(str, tmp.get(str) - 1);
                  }
              }
              
              if (endIdx - i == totalLen) {
                  res.add(i);
              }
          }
      }
                  
      return res;
  }
}