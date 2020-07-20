/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  let phoneBook = {
      '2': 'abc',
      '3': 'def',
      '4': 'ghi',
      '5': 'jkl',
      '6': 'mno',
      '7': 'pqrs',
      '8': 'tuv',
      '9': 'wxzy',
  };
  let res = [];
  let queue = new Array();
  queue.unshift('');

  for (let i = 0; i < digits.length; i++) {
      let size = queue.length;

      for (let j = 0; j < size; j++) {
          let str = queue.pop();
          let next = phoneBook[digits[i]];
          
          for (let k = 0; k < next.length; k++) {
              let tmp = str + next[k];
              queue.unshift(tmp);
              if (i == digits.length - 1) {
                  res.push(tmp);
              }
          }
      }
  }

  return res;
};
