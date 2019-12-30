class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
      LinkedList<Integer> stack = new LinkedList<>();
      int pos = 0;
      
      for (int p: pushed) {
          if (p != popped[pos]) {
              stack.push(p);
          } else {
              pos++;
          }
          while (!stack.isEmpty() && pos < popped.length && stack.peek() == popped[pos]) {
              stack.pop();
              pos++;
          }
      }
      
      return stack.size() == 0;
  }
}