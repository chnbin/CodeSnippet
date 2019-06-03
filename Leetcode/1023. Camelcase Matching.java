import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Boolean> camelMatch(String[] queries, String pattern) {
      List<Boolean> res = new ArrayList<>();
      
      for (String query: queries) {
          res.add(isMatch(query, pattern));
      }
      return res;
  }
  
  /**
   * Use variable pos to indicate pattern current location, pos starts from zero.
   * If query.charAt(i) is equal to pattern[pos] then pos plus one.
   * If query.charAt(i) is an uppercase character and pattern dose not contain this character,
   * return false. 
   * 
   * Cases:
   * (query = FoBarTest, pattern = FoBa return false)
   * (query = FoBarm , pattern = FoBa return true)
   * @param query
   * @param pattern
   * @return
   */
  private boolean isMatch(String query, String pattern) {
      int pos = 0;
      
      for (int i = 0; i < query.length(); i++) {
          char c = query.charAt(i);
          
          if (pos < pattern.length() && c == pattern.charAt(pos)) {
              pos++;
          } else if (('A' <= c) && (c <= 'Z')) {
              return false;
          }
      }
      return pos == pattern.length();
  }              
}