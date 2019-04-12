/**
 * @param {number[][]} grid
 * @return {number}
 */
var swimInWater = function(grid) {
  let left = 0;
  let right = grid.length * grid.length - 1;
  
  while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      
      if (reachAble(grid, mid)) {
          right = mid - 1;
      } else {
          left = mid + 1;
      }
  }
  return left;
};

function reachAble(grid, step) {
  let queue = [[0, 0]];
  let visited = [];
  const M = grid.length;
  const directions = [[0, 1], [0, -1], [1, 0], [-1, 0]];
  
  while (typeof queue !== 'undefined' && queue.length > 0) {
      const [x, y] = queue.pop();
      
      if (x === M - 1 && y === M - 1) {
          return true;
      }
      visited.push(x.toString() + '-' + y.toString());
      // console.log(visited);
      for (let direct of directions) {
          const [dx, dy] = direct;
          const newX = x + dx;
          const newY = y + dy;
          const newPos = newX.toString() + '-' + newY.toString();
          
          if ((newX >= 0 && newX < M) && (newY >= 0 && newY < M)) {
              if (!visited.includes(newPos) && grid[newX][newY] <= step && grid[x][y] <= step) {
                  queue.push([newX, newY]);
              }
          }
      }
  }
  
  return false;
}