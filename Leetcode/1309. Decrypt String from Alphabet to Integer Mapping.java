class Solution {
  public String freqAlphabets(String s) {
      StringBuilder sb = new StringBuilder();
      LinkedList<Integer> stack = new LinkedList<>();
      
      for (char c: s.toCharArray()) {
          if (c == '#') {
              int sum = stack.pop();
              sum += (10* stack.pop());
              stack.push(sum);
          } else {
              stack.push(c - '0');
          }
      }
      
      while (!stack.isEmpty()) {
          char c = (char)((int)'a' + (int)(stack.pop() - 1));
          sb.insert(0, "" + c);
      }
      return sb.toString();
  }
}