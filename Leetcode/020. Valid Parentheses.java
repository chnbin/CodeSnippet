import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
  public boolean isValid(String s) {
      LinkedList<Character> stack = new LinkedList<Character>();
      Map<Character, Character> table = new HashMap<Character, Character>();
      table.put(')', '(');
      table.put(']', '[');
      table.put('}', '{');
      
      for (char c: s.toCharArray()) {
          if (c == '(' || c == '[' || c == '{') {
              stack.push(c);
          } else {
              if (stack.size() == 0 || stack.pop() != table.get(c)) {
                  return false;
              }
          }
      }
      return stack.size() == 0;
  }
}