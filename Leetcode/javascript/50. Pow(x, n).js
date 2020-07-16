/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
  if (n >= 0) {
      return myPowHelper(x, n);
  }
  return 1.0 / myPowHelper(x, n);
};

let myPowHelper = (x, n) => {
  if (n === 0) { return 1; }
  // You must convert n / 2 to integer. 
  let y = myPowHelper(x, parseInt(n / 2));
  if (n % 2 == 0) {
      return y * y;
  }
  return y * y * x;
}
