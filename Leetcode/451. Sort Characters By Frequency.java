class Solution {
  public String frequencySort(String s) {
      if (s == null || s.length() == 0) { return ""; }
      Map<Character, Integer> map = new HashMap<>();
      
      // Step 1: Obtain frequence of each character and find the maximum frequence
      int maxCnt = 0; // the maximum frequence of character
      for (char c: s.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
          maxCnt = Math.max(maxCnt, map.get(c));
      }
      
      // Step 2: Use array as bucket, the bucket number is the frequence
      //         Put the character into corresponding bucket
      List<Character>[] list = new ArrayList[maxCnt + 1];
      
      for (Character c: map.keySet()) {
          int freq = map.get(c);
          if (list[freq] == null) {
              list[freq] = new ArrayList<>();
          }
          list[freq].add(c);
      }
      
      // Step 3. Build answer from bucket
      StringBuilder sb = new StringBuilder();
      
      for (int i = list.length - 1; i >= 0; i--) {
          List<Character> l = list[i];
          if (l != null) {
              for (Character chr: l) {
                  for (int j = 0; j < i; j++) {
                      sb.append(chr);
                  }
              }
          }
      }
      
      return sb.toString();
  }
}
