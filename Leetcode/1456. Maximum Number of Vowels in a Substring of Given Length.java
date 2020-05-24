class Solution {
  /*
    Use sliding window to solve this problem.
  */
  public int maxVowels(String s, int k) {
      int res = 0;
      int cnt = 0;
      Set<Character> set = createVowelsSet();

      // Step 1: Count vowels of first k characters.
      for (int i = 0; i < k; i++) {
          if (set.contains(s.charAt(i))) {
              cnt++;
          }
      }
      
      res = Math.max(res, cnt);
      
      // Step 2: Update vowel counts of each k substring
      for (int i = k; i < s.length(); i++) {
          if (set.contains(s.charAt(i))) {
              cnt++;
          }
          
          if (set.contains(s.charAt(i - k))) {
              cnt--;
          }
          
          res = Math.max(res, cnt);
      }
      
      return res;
  }
  
  private Set<Character> createVowelsSet() {
      char[] vowels = {'a', 'e', 'i', 'o', 'u'};
      Set<Character> set = new HashSet<>();
      
      for (char vowel: vowels) {
          set.add(vowel);
      }
      return set;
  }
}
