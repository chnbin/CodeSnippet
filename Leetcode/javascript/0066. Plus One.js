/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  let carry = 1;
  let n = digits.length - 1;
  
  while (n >= 0) {
      let sum = digits[n] + carry;
      digits[n] = sum % 10;
      carry = (sum > 9) ? 1: 0;
      
      n--;
  }
  
  if (carry > 0) {
      digits = [1].concat(digits);
  }
  return digits;
};
