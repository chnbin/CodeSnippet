class Solution {
  public String removeKdigits(String num, int k) {
      if (num == null || num.length() == 0 || num.length() <= k) {
          return "0";
      }
      LinkedList<Character> stack = new LinkedList<>();
      
      for (char c: num.toCharArray()) {
          int n = (c - '0');
          
          while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
              stack.pop();
              k--;
          }
          stack.push(c);
      }
      
      while (!stack.isEmpty() && k > 0) {
          stack.pop();
          k--;
      }
      
      StringBuilder sb = new StringBuilder();
      while (!stack.isEmpty()) {
          sb.append(stack.pop());
      }
      
      sb.reverse();
      
      while (sb.length() > 0 && sb.charAt(0) == '0') {
          sb.deleteCharAt(0);
      }
      
      return (sb.length() == 0) ? "0" : sb.toString();
  }
}