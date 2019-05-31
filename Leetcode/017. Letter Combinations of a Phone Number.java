import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
  public List<String> letterCombinations(String digits) {
      if (digits == null || digits.length() == 0) {
          return new ArrayList<String>();
      }
      Map<Character, String> map = new HashMap<>();
      map.put('2', "abc");
      map.put('3', "def");
      map.put('4', "ghi");
      map.put('5', "jkl");
      map.put('6', "mno");
      map.put('7', "pqrs");
      map.put('8', "tuv");
      map.put('9', "wxyz");

      List<String> res = new ArrayList<String>();
      Queue<String> queue = new LinkedList<>();
      queue.offer("");
      
      while (!queue.isEmpty()) {
          String s = queue.poll();
          if (s.length() == digits.length()) {
              res.add(s);
          } else {
              // Very smart!
              for (char c: map.get(digits.charAt(s.length())).toCharArray()) {
                  queue.offer(s + c);
              }
          }
      }
      return res;
  }
}