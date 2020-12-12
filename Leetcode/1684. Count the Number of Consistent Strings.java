class Solution {
  public int countConsistentStrings(String allowed, String[] words) {
      int res = 0;
      
      Set<Character> set = new HashSet<>();
      
      for (char c: allowed.toCharArray()) {
          set.add(c);
      }
      
      for (String word: words) {
          boolean isConsistent = true;
          
          for (char c: word.toCharArray()) {
              if (!set.contains(c)) {
                  isConsistent = false;
              }
          }
          
          if (isConsistent) { res++; }
      }
      
      return res;
  }
}
