class Solution {
  private static int [][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int shortestPath(int[][] grid, int k) {
     int m = grid.length; int n = grid[0].length; 
     if(m == 1 && n == 1) {
         return 0; 
     }
      //fast the search spee
     k = Math.min(k, m + n -3); 
     boolean visited [][][] = new boolean[m][n][k + 1]; 
     Queue<grid> q = new LinkedList();  
     q.offer(new grid(0,0,k)); 
     visited [0][0][k ] = true; 

     for(int step = 1 ; q.size() > 0; step++) {
         int size = q.size(); 
         for(int j = 0; j < size; j++) {
             grid g= q.poll(); 
             for(int i = 0; i < 4; i++) {
                 int dx = g.x + direct[i][0]; 
                 int dy = g.y + direct[i][1]; 
                 int b = g.steps; 

                 if( dx >= 0 && dx < m && dy >= 0 && dy< n) {
                     if(grid[dx][dy] == 0 &&  !visited[dx][dy][g.steps]) {
                         if(dx == m -1 && dy == n-1) {
                             return step;// this is the next layer start place
                         }
                         q.offer(new grid(dx, dy, g.steps)); 
                         visited[dx][dy][g.steps] = true; 
                     } else if(grid[dx][dy] == 1  && g.steps > 0 && !visited[dx][dy][g.steps -1]) {
                         q.offer(new grid(dx, dy, g.steps-1)); 
                         visited[dx][dy][g.steps -1] = true; 
                     } 
                 }
             }
         }
     }
     return -1; 

  }
}


class grid {
  int x, y;
  int steps;
  grid(int x, int y, int steps) {
      this.x = x;
      this.y = y;
      this.steps = steps;
  }
}