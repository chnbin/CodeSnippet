import java.util.LinkedList;

class Solution {
  public TreeNode recoverFromPreorder(String S) {
      if (S == null || S.length() == 0) {
          return null;
      }
      int idx = 0;
      LinkedList<Item> stack = new LinkedList<Item>();
      TreeNode root = null;
  
      while (idx < S.length()) {
          char ch = S.charAt(idx);
          int currLevel = 0;
          int currValue = 0;
          int j = idx;
          boolean isPop = false;
          if (ch == '-') {
              while ((j < S.length()) && S.charAt(j) == '-') {
                  currLevel++;
                  j++;
              }
              
              while (currLevel <= stack.peek().currLevel) {
                  stack.pop();
                  isPop = true;
              }
          }
          idx = j;
          
          if (('0' <= S.charAt(j)) && (S.charAt(j) <= '9')) {
              while ((j < S.length()) && (('0' <= S.charAt(j)) && (S.charAt(j) <= '9'))) {
                  currValue = currValue * 10 + (S.charAt(j) - '0');
                  j++;
              }
          }
          
          idx = j;

          TreeNode node = new TreeNode(currValue);
          if (root == null) {
              root = node;
          }
          
          if (!stack.isEmpty()) {
              if (isPop) {
                  stack.peek().node.right = node;
              } else {
                  stack.peek().node.left = node;
              }  
          }

          stack.push(new Item(node, currLevel));
      }
      return root;
  }
}

class Item {
  int currLevel;
  TreeNode node;
  public Item(TreeNode node, int currLevel) {
      this.node = node;
      this.currLevel = currLevel;
  }
}