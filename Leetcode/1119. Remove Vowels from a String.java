import java.util.HashSet;
import java.util.Set;

class Solution {
  public String removeVowels(String S) {
      StringBuilder sb = new StringBuilder();
      Set<Character> vowels = createSet("aeiou");
      
      for (char c: S.toCharArray()) {
          if (!vowels.contains(c)) {
              sb.append(c);
          }
      }
      return sb.toString();
  }
  
  public Set<Character> createSet(String s) {
      Set<Character> set = new HashSet<>();
      
      for (char c: s.toCharArray()) {
          set.add(c);
      }
      return set;
  }
}