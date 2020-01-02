class Solution {
  public String reverseParentheses(String s) {
      if (s == null || s.length() == 0) { return ""; }
      LinkedList<String> stack = new LinkedList<>();
      StringBuilder sb = new StringBuilder();
      int balance = 0; // ( + 1, ) - 1
      
      
      for (char c: s.toCharArray()) {
          // 如果是(, (要進去堆疊
          if (c == '(') {
              balance++;
              stack.push("" + c);
              continue;
          }
          
          // 如果非(, 且已經沒有()，就要直接進去答案
          if (c != ')' && balance == 0) {
              sb.append(c);
              continue;
          }
          
          // 如果非(, 且已經有()，就要把字元丟進去堆疊
          if (c != ')') {
              stack.push("" + c);
              continue;
          }
          
          // 剩下的只有剩下)的情況了。
          StringBuilder tmp = new StringBuilder();
          // 在堆疊遇到)之前，把堆疊pop，翻轉之後加入暫時答案
          while (!stack.peek().equals("(")) {
              StringBuilder e = new StringBuilder();
              tmp.append(e.append(stack.pop()).reverse());
          }
          
          // 處理完字串後將( pop掉
          stack.pop();
          
          // 若堆疊為空，暫時答案就得進去答案裡，否則這暫時答案得入堆疊
          if (stack.isEmpty()) {
              sb.append(tmp.toString());
          } else {
              stack.push(tmp.toString());
          }
          
          // 遇到)，所以balance得減1
          balance--;
      }
      
      return sb.toString();
  }
}