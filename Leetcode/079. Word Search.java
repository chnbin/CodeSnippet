class Solution {
  public boolean exist(char[][] board, String word) {
      // need to dfs a word, don't re-visit a same node on the path
      if (board == null || board.length == 0 || board[0].length == 0 || word == null) return false;
      boolean[][] used = new boolean[board.length][board[0].length];
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              if (word.charAt(0) == board[i][j] && dfs(board, word, 0, i, j, used)) return true;
          }
      }
      return false;
  }
  
  private boolean dfs(char[][] board, String word, int k, int i, int j, boolean[][] used) {
      if (k == word.length()) return true;
      if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] || word.charAt(k) != board[i][j]) return false;
      
      used[i][j] = true;
      if (dfs(board, word, k+1, i+1, j, used) || dfs(board, word, k+1, i-1, j, used) || 
          dfs(board, word, k+1, i, j+1, used) || dfs(board, word, k+1, i, j-1, used)) {
          return true;
      }
      used[i][j] = false;
      return false;
  }
}