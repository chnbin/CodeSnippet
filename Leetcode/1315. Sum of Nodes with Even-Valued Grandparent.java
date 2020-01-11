/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  private int res = 0;
  public int sumEvenGrandparent(TreeNode root) {
      if (root == null) { return 0; }
      Set<Integer> grandChildLevel = new HashSet<>();
      sumEvenGrandparent(root, grandChildLevel, 0);
      return res;
  }
  
  private void sumEvenGrandparent(TreeNode node, Set<Integer> gcLevel, int currPos) {
      if (node == null) { return; }
      
      if (gcLevel.contains(currPos)) {
          res += node.val;
      }
      
      if (node.val % 2 == 0) {
          gcLevel.add(2*(2*currPos + 1) + 1);
          gcLevel.add(2*(2*currPos + 1) + 2);
          gcLevel.add(2*(2*currPos + 2) + 1);
          gcLevel.add(2*(2*currPos + 2) + 2);
      }
      
      sumEvenGrandparent(node.left, gcLevel, 2 * currPos + 1);
      sumEvenGrandparent(node.right, gcLevel, 2 * currPos + 2);
  }
}