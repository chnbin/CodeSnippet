/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  let res = [];
  helper(res, n, n, '', 2 * n);
  return res;
};

let helper = (res, left, right, str, n) => {
  if (str.length == n) {
      res.push(str);
      return;
  }
  
  if (left > 0) {
      helper(res, left - 1, right, str + '(', n);
  }
  
  if (right > left) {
      helper(res, left, right - 1, str + ')', n);
  }
}
