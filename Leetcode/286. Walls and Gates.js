/**
 * https://leetcode.com/problems/walls-and-gates/
 * @param {number[][]} rooms
 * @return {void} Do not return anything, modify rooms in-place instead.
 */
var wallsAndGates = function(rooms) {
  if (typeof rooms === 'undefined' || rooms.length === 0) {
      return;
  }

  let queue = [];
  let M = rooms.length;
  let N = rooms[0].length;
  let directions = [[0, 1], [0, -1], [1, 0], [-1, 0]];

  for (let i = 0; i < M; i++) {
      for (let j = 0; j < N; j++) {
          if (rooms[i][j] === 0) {
              queue.push([i, j]);
          }
      }
  }

  while (typeof queue !== 'undefined' && queue.length > 0) {
      const [x, y] = queue.pop();
      
      for (let direction of directions) {
          const [dx, dy] = direction;
          const newX = x + dx;
          const newY = y + dy;

          if ((newX >= 0 && newX < M) && (newY >= 0 && newY < N)) {
              if (rooms[newX][newY] !== -1) {
                  if (rooms[x][y] + 1 < rooms[newX][newY]) {
                      queue.push([newX, newY]);
                      rooms[newX][newY] = rooms[x][y] + 1;
                  }
              }
          }
      }
  }
};