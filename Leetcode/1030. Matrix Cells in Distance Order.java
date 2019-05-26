import java.util.LinkedList;
import java.util.Queue;

class Solution {
  int[][] dirs = new int[][] {{0,1}, {1,0}, {-1, 0}, {0, -1}};
  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
      boolean[][] visited = new boolean[R][C];
      visited[r0][c0] = true;
      
      Queue<int[]> queue = new LinkedList();
      queue.offer(new int[] {r0, c0});
      
      int[][] res = new int[R*C][2];
      int i = 0;
      
      while(!queue.isEmpty()) {
          int[] curr = queue.poll();
          res[i++] = curr;
          
          for(int[] dir: dirs){
              int nX = curr[0] + dir[0];
              int nY = curr[1] + dir[1];
              
              if(nX >= 0 && nX < R && nY >= 0 && nY < C && !visited[nX][nY]) {
                  visited[nX][nY] = true;
                  queue.offer(new int[] {nX, nY});
              }
          }
      }
      
      return res;
  }
}