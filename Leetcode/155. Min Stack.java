import java.util.LinkedList;

class MinStack {
  LinkedList<Integer> stack;
  LinkedList<Integer> stackForMin;
  
  /** initialize your data structure here. */
  public MinStack() {
      stack = new LinkedList<>();
      stackForMin = new LinkedList<>();
  }
  
  public void push(int x) {
      stack.push(x);
      if (stackForMin.size() == 0) {
          stackForMin.push(x);
          return ;
      }
      if (x <= stackForMin.peek()) {
          stackForMin.push(x);
      }
  }
  
  public void pop() {
      int p = stack.pop();
      if (p == stackForMin.peek()) {
          stackForMin.pop();
      }
  }
  
  public int top() {
      return stack.peek();
  }
  
  public int getMin() {
      return stackForMin.peek();
  }
}
