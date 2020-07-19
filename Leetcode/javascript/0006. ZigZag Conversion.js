/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
  if (numRows === 1) {
      return s;
  }
  let step = 0;
  let direct = -1;
  let ans = new Array(numRows);
  ans.fill('');
  
  for (let i = 0; i < s.length; i++) {
      ans[step] += s[i];
      
      if (step === 0 || step === (numRows - 1)) {
          direct = -direct;
      }
      
      step += direct;
  }
  
  return ans.join('');
};
