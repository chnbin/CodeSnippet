// First example of reduce
const nums = [1, 2, 3, 4, 5];
let sum = 0;

for (let i = 0; i < nums.length; i++) {
  sum += nums[i];
}

console.log(sum);

// reduce(callback[accumlator, currentValue, currentIndex, array], initialValue)
sum = nums.reduce((sum, num) =>{
  return sum + num;
}, 0);

console.log(sum);

// Second example of reduce
const primaryColors = [
  {color: 'red'},
  {color: 'blue'},
  {color: 'green'},
  {color: 'yellow'},
];

const colors = primaryColors.reduce((previous, primaryColor) => {
  previous.push(primaryColor.color);
  return previous;
}, []);

console.log(colors);

// Valid Parentheses
const str = '()()()';

/**
 * Valid Parentheses are balanced or not.
 * @param {string} str postr only contains ( or ).
 * @return {boolean}
 */
function isValid(str) {
  return str.split('').reduce((previous, char) => {
    if (previous < 0) {
      return previous;
    }
    if (char === '(') {
      previous += 1;
    }
    if (char === ')') {
      previous -= 1;
    }
    return previous;
  }, 0);
}

console.log(isValid(str) === 0);
console.log(isValid('()') === 0);
console.log(isValid('((((') === 0);
console.log(isValid(')(') === 0);

/**
 * Find unique elements in given array.
 * @param {number[]} array postr only contains ( or ).
 * @return {number[]} unique elements of array
 */
function unique(array) {
  return array.reduce((acc, num) => {
    if (!acc.includes(num)) {
      acc.push(num);
    }
    return acc;
  }, []);
}

const numbers = [1, 2, 3, 1, 2, 4, 2, 5, 6, 7];
console.log(unique(numbers));
