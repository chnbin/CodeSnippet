/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
  if (x < 0) {
      return false;
  }

  let tmp = x;
  let sum = 0;
  
  while (tmp > 0) {
      sum *= 10;
      sum += tmp % 10;
      tmp = Math.floor(tmp/10);
  }
  
  return sum === x;
};
