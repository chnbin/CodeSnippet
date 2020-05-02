/*
  30 day leetcoding challenge
  Day 30. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
  https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/
*/

class Solution {
  public boolean isValidSequence(TreeNode root, int[] arr) {
      return isValidSequenceHelper(root, arr, 0);
  }
  
  // DFS solution
  // Time complexity: O(n)
  // Space complexity: O(n), where n is the numbers of tree
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

  // BFS solution
  // Time complexity: O(n)
  // Space complexity: O(n), where n is the numbers of tree
  public boolean isValidSequenceBFS(TreeNode root, int[] arr) {
    Queue<TreeNode> queue = new LinkedList<>();
    int pos = 0;
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            
            if (pos > arr.length - 1) {
                return false;
            }
            
            if (node.val != arr[pos]) {
                continue;
            }
            
            if (node.left == null && node.right == null && (pos == arr.length - 1)) {
                return true;
            }
            
            if (node.left != null) { queue.offer(node.left); }
            if (node.right != null) { queue.offer(node.right); }
        }
        pos++;
    }
    
    return false;
  }
}
