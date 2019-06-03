import java.util.LinkedList;

class Solution {
  public int clumsy(int N) {
      if (N == 1) { return 1; }
      char[] symbol = {'*', '/', '+', '-'};
      LinkedList<Integer> stack = new LinkedList<>();
      stack.push(N);
      int res = 0;
      
      for (int i = 0; i < N - 1; i++) {
          char op = symbol[i % 4];
          
          if (op == '*') {
              stack.push(stack.pop() * (N - i - 1));
          } else if (op == '/') {
              stack.push(stack.pop() / (N - i - 1));
          } else if (op == '+') {
              stack.push(stack.pop() + (N - i - 1));
          } else {
              stack.push(-(N - i - 1));
          }
      }
      
      while (!stack.isEmpty()) {
          res += stack.pop();
      }
      return res;
  }
}