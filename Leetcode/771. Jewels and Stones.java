import java.util.HashSet;

class Solution {
  public int numJewelsInStones(String J, String S) {
      HashSet<Character> set = new HashSet<Character>();
      int res = 0;
      for (char c: J.toCharArray()) {
          set.add(c);
      }
      
      for (char c: S.toCharArray()) {
          if (set.contains(c)) { res++; }
      }
      
      return res;
  }
}