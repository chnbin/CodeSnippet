class Solution {
  public String makeGood(String s) {
      Stack<Character> stack = new Stack<>();
      
      for (char c: s.toCharArray()) {
          if (stack.isEmpty()) {
              stack.push(c);
              continue;
          }
          
          if (Math.abs((int)c - (int)stack.peek()) == 32) {
              stack.pop();
          } else {
              stack.push(c);
          }
      }
      
      String res = "";
      
      while (!stack.isEmpty()) {
          res = stack.pop() + res;
      }
      
      return res;
  }
}
