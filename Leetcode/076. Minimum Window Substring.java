import java.util.HashMap;

class Solution {
  public String minWindow(String s, String t) {
      int start = 0;
      int end = 0;
      int len = Integer.MAX_VALUE;
      int counter = 0;
      String ans = "";
      HashMap<Character, Integer> table = new HashMap<Character, Integer>();
      
      for(char c: t.toCharArray()) {
          if (table.containsKey(c)) {
              table.put(c, table.get(c) + 1);
          } else {
              table.put(c, 1);
          }
      }
      
      counter = table.size();
      
      while (end < s.length()) {
          char endChar = s.charAt(end);
          
          if (table.containsKey(endChar)) {
              table.put(endChar, table.get(endChar) - 1);
              if(table.get(endChar) == 0) {
                  counter--;
              }
          }
          
          while (counter == 0) {
              if (end - start < len) {
                  len = end - start;
                  ans = s.substring(start, end + 1);
              }
              
              char startChar = s.charAt(start);
              
              if (table.containsKey(startChar)) {
                  table.put(startChar, table.get(startChar) + 1);
                  if (table.get(startChar) > 0) {
                      counter++;
                  }
              }
              start++;
          }
          
          end++;
      }
      
      return ans;
  }
}