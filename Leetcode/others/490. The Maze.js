/**
 * https://leetcode.com/problems/the-maze/
 * @param {number[][]} maze
 * @param {number[]} start
 * @param {number[]} destination
 * @return {boolean}
 */
var hasPath = function(maze, start, destination) {
  if (typeof maze === 'undefined' || maze.length === 0) {
      return false;
  }

  let queue = [start];
  let M = maze.length;
  let N = maze[0].length;

  let directions = [[0, 1], [0, -1], [1, 0], [-1, 0]];
  
  while (typeof queue !== 'undefined' && queue.length > 0) {
      const [x, y] = queue.pop();

      // Set visited
      maze[x][y] = -1;
      
      if (x === destination[0] && y === destination[1]) {
          return true;
      }
      for (let direct of directions) {
          const [dx, dy] = direct;
          let newX = x + dx;
          let newY = y + dy;
          
          while ((0 <= newX && newX < M) && 
                 (0 <= newY && newY < N) && 
                 maze[newX][newY] !== -1) {
              newX += dx;
              newY += dy;
          }
          newX -= dx;
          newY -= dy;
          
          if (maze[newX][newY] === 0) {
              queue.push([newX, newY]);
          }
      }
  }
  return false;
};

console.log(hasPath([[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], [0,4], [4,4]));