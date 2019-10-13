class Solution {
  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
      List<List<Integer>> res = new ArrayList<>();
      int[] dx = {-1, -1, -1,  0, 0,  1, 1,  1};
      int[] dy = {-1,  0,  1, -1, 1, -1, 0,  1};
      boolean[][] chessboard = new boolean[8][8];
      
      for (int[] loc: queens) {
          chessboard[loc[0]][loc[1]] = true;
      }
      
      // 總共有八個方向，每個方向都由King為起點一直衍生出去，遇到的第一個就是要加進去的
      for (int i = 0 ; i < 8; i++) {
          int x = king[0];
          int y = king[1];
          int newX = x + dx[i];
          int newY = y + dy[i];
          
          while ((0 <= newX) && (newX < 8) && (0 <= newY) && (newY < 8)) {
              if (chessboard[newX][newY]) {
                  List<Integer> queen = new ArrayList<Integer>();
                  queen.add(newX);
                  queen.add(newY);
                  res.add(queen);
                  break;
              }
              newX += dx[i];
              newY += dy[i];
          } 
      }
      return res;
  }
}