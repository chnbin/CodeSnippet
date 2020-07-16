/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
  if (grid === undefined || grid.length === 0 || grid[0].length === 0) {
      return 0;
  }
  const DIRS = [[1, 0], [0, -1], [0, 1], [0, -1]];
  let m = grid.length;
  let n = grid[0].length;
  let res = 0;
  
  for (let i = 0; i < m; i++) {
      for (let j = 0; j < n; j++) {
          if (grid[i][j] === '1') {
              dfs(grid, i, j);
              res++;
          }
      }
  }
  
  return res;
};

let dfs = (grid, r, c) => {
  // console.log(r, c);
  if (r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length -1) {
      return;
  }
  if (grid[r][c] === '0') {
      return;
  }
  
  grid[r][c] = '0';
  
  const DIRS = [[1, 0], [-1, 0], [0, 1], [0, -1]];
  
  for (let i = 0; i < DIRS.length; i++) {
      dfs(grid, r + DIRS[i][0], c + DIRS[i][1]);
  }
}