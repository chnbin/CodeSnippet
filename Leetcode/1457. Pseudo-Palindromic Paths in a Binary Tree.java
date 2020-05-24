class Solution {
  /*
      A palindromic string is consisted by 2 conditions:
          1. Frequencies of each character is all even.
          2. Only one frequncy is odd and the others are all even.
      So we can do DFS and check if the path is pseudo-palindromin or not in the leaf.
      Time complexity: O(N)
      Space complexity: O(c)
  */
  private int res = 0;
  
  public int pseudoPalindromicPaths (TreeNode root) {
      int[] freqs = new int[10];
      pathHelper(root, freqs);
      return res;
  }
  
  private void pathHelper(TreeNode node, int[] freqs) {
      if (node.left == null && node.right == null) {
          // check if pseudo-palindromic or not
          freqs[node.val]++;
          int odd = 0;
          
          for (int freq: freqs) {
              if (freq % 2 == 1) {
                  odd++;
              }
          }
                      
          if (odd == 1 || odd == 0) { res++; }
          
          freqs[node.val]--;
      }
      
      freqs[node.val]++;
      if (node.left != null) { pathHelper(node.left, freqs); }
      if (node.right != null) { pathHelper(node.right, freqs); }
      freqs[node.val]--;
  }
}