class Solution {
  public String convert(String s, int numRows) {
      if (s == null || s.length() == 0) {
          return "";
      }
      
      if (numRows == 1) {
          return s;
      }
      
      String[] groups = new String[numRows];
      String ans = "";
      int pos = 0;
      int direction = -1;
      
      for (int i = 0; i < numRows; i++) {
          groups[i] = "";
      }
      
      for (int i = 0; i < s.length(); i++) {
          groups[pos] += s.charAt(i);
          
          if (pos == 0 || pos == (numRows - 1)) {
              direction *= -1;
          }
          pos += direction;
      }
      
      for (String group: groups) {
          ans += group;
      }
      return ans;
  }
}