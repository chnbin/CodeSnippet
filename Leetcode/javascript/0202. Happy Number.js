/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
  if (n === 1) { return true; }
  let s = new Set();
  
  while (n != 1 && !s.has(n)) {
      s.add(n);
      let total = 0;
      
      while (n > 0) {
          total += ((n % 10) ** 2);
          n = parseInt(n /10);
      }
      
      if (total == 1) { return true; }
      n = total;
  }
  
  return false;
};
