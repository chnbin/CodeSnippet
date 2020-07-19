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
      let num1 = a[m] ? parseInt(a[m]) : 0;
      let num2 = b[n] ? parseInt(b[n]) : 0;
      let total = num1 + num2 + carry;
      carry = 0;

      if (total > 1) {
        total = total % 2;
        carry = 1;
      }
      res = `${total}${res}`;
      m--;
      n--;
  }
  
  if (carry > 0) {
      res = `${carry}${res}`;
  }
  
  return res;
};