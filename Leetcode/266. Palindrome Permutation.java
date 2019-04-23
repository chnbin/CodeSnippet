import java.util.HashSet;

class Solution {
  public boolean canPermutePalindrome(String s) {
      HashSet<Character> set = new HashSet<Character>();
      
      for (char c: s.toCharArray()) {
          if (set.contains(c)) {
              set.remove(c);
          } else {
              set.add(c);
          }
      }
      return set.size() <= 1;
  }
}