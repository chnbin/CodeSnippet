function searchMatrix(matrix: number[][], target: number): boolean {
  if (matrix === null || matrix.length === 0 || matrix[0].length === 0) {
      return false;
  }
  let rows = matrix.length;
  let cols = matrix[0].length;
  let left = 0;
  let right = rows * cols - 1;
  
  while (left <= right) {
      let mid = Math.floor((left + right) / 2);
      
      if (matrix[Math.floor(mid/cols)][mid%cols] === target) {
          return true;
      } else if (matrix[Math.floor(mid/cols)][mid%cols] < target) {
          left = mid + 1;
      } else {
          right = mid - 1;
      }
      
  }
  
  return false;
};
