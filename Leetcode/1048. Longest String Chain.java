class Solution {
  public int longestStrChain(String[] words) {
      int res = 0;
      Arrays.sort(words, (a, b) -> {
          return a.length() - b.length();
      });
      
      Map<String, Integer> map = new HashMap<>();
      
      for (String word: words) {
          if (map.containsKey(word)) { continue; }
          
          map.put(word, 1);
          
          for (int i = 0; i < word.length(); i++) {
              StringBuilder sb = new StringBuilder(word);
              
              sb.deleteCharAt(i);
              
              String next = sb.toString();
              
              if (map.containsKey(next) && map.get(next) + 1 > map.get(word)) {
                  map.put(word, map.get(next) + 1);
              }
          }
          res = Math.max(res, map.get(word));
      }
      
      return res;
  }
}