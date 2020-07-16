/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
  if (root === null) { return 0; }
  let res = [1];
  maxDepthHelper(root, 1, res);
  
  return res[0];
};

let maxDepthHelper = (node, depth, res) => {
  if (node.left === null && node.right === null) {
      res[0] = Math.max(res[0], depth);
  }
  
  if (node.left !== null) {
      maxDepthHelper(node.left, depth + 1, res);
  }
  
  if (node.right !== null) {
      maxDepthHelper(node.right, depth + 1, res);
  }
}
