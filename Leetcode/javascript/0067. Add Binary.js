/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
  res = '';
  let m = a.length - 1;
  let n = b.length - 1;
  let carry = 0;
  
  while (m >= 0 || n >= 0) {
      let aInt = 0;
      let bInt = 0;
      
      if (m >= 0) {
          aInt = a[m] - '0';
          m--;
      }
      
      if (n >= 0) {
          bInt = b[n] - '0';
          n--;
      }
      let total = aInt + bInt + carry;
      carry = parseInt(total / 2);
      total = parseInt(total % 2);
      
      res = +total + res;
  }
  
  if (carry > 0) {
      res = +carry + res;
  }
  
  return res;
};