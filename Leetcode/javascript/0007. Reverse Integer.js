/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
  let sign = 1;
  let ans = 0;

  if (x < 0) {
      sign = -1;
      x = -x;
  }
  
  while (x > 0) {
      ans = (ans * 10) + (x % 10);
      if (ans > (Math.pow(2, 31) - 1) || ans < -Math.pow(2, 32)) {
          return 0;
      }
      x = Math.floor(x/10);
  }
  
  return sign * ans;
  
};
