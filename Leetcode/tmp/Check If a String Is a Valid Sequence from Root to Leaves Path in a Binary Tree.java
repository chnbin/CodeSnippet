package tmp;

 /*
  30 day leetcoding challenge
  Day 30. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
  https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
 */

class Solution {
  public boolean isValidSequence(TreeNode root, int[] arr) {
      return isValidSequenceHelper(root, arr, 0);
  }
  
  private boolean isValidSequenceHelper(TreeNode node, int[] arr, int pos) {
      if (pos > arr.length - 1) { return false; }
      
      if (node.val == arr[pos]) {
          boolean left = false;
          if (node.left != null) {
              left = isValidSequenceHelper(node.left, arr, pos + 1);
          }
          
          boolean right = false;
          if (node.right != null) { 
              right = isValidSequenceHelper(node.right, arr, pos + 1);
          }
          
          if (node.left == null && node.right == null && (pos == arr.length - 1)) {
              return true;
          }
          
          return left || right;
      }
      return false;
  }
}
