class Solution {
  public List<String> stringMatching(String[] words) {
      List<String> res = new ArrayList<>();
      
      for (int i = 0; i < words.length - 1; i++) {
          String w = words[i];
          for (int j = i + 1; j < words.length; j++) {
              String m = words[j];
              
              if (w.contains(m) && !res.contains(m)){
                  res.add(m);
              }
              
              if (m.contains(w) && !res.contains(w)){
                  res.add(w);
              }
          }
      }
      
      return res;
  }
}