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
 * @param {number} sum
 * @return {boolean}
 */
var hasPathSum = function(root, sum) {
  return hasPathSumHelper(root, sum);
};

let hasPathSumHelper = (node, sum) => {
  if (node === null) {
      return false;
  }
  if (node.left === null && node.right === null) {
      if (sum - node.val === 0) {
          return true;
      }
      return false;
  }
  
  return hasPathSumHelper(node.left, sum - node.val) || hasPathSumHelper(node.right, sum - node.val);
}
