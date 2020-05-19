/*
  Mononic stack, this problem is very similar with Problem 739. Daily Temperatures.
 */
class StockSpanner {
  LinkedList<int[]> stack = new LinkedList<>();
  
  public int next(int price) {
      int span = 1;
      
      while (!stack.isEmpty() && price >= stack.peek()[0]) {
          span += stack.pop()[1];
      }
      
      stack.push(new int[]{price, span});
      return span;
  }
}
