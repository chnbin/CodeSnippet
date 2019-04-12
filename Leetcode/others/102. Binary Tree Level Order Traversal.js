/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  if (!root) {
      return [];
  }

  let res = [];
  let level = [root];

  while (typeof level !== 'undefined' && level.length > 0) {
      let tmp = [];
      thisLevel = [];
      for (let node of level) {
          thisLevel.push(node.val);
          tmp.push(node.left);
          tmp.push(node.right);
      }

      res.push(thisLevel);
      level = [];
      
      for (let newNode of tmp) {
          if (newNode) {
              level.push(newNode);
          }
      }
  }
  return res;
};