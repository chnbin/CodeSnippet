/* Array.map
   nums                               result
     1 => iterator function => return    1
     2 => iterator function => return    4
     3 => iterator function => return    9
     ...
*/

const nums = [1, 2, 3, 4, 5];

const result = nums.map((num) => {
  return num * num;
});

console.log(result);

// A simple Array.map example 2
const images = [
  {height: '1024px', width: '768px'},
  {height: '800px', width: '600px'},
  {height: '1320px', width: '976px'},
];

const heights = images.map((image) => {
  return image.height;
});

console.log(heights);


// Return an array consisting of the largest number from
// each provided sub-array.

/**
 * Find the largest number from item.
 * @param {number[]} arr a number list.
 * @return {number} The largest number of arr.
 */
function largestOfFour(arr) {
  // You can do this!
  return arr.map((item) => {
    return Math.max.apply(null, item);
  });
}

const tmp = largestOfFour([
  [4, 9, 1, 3],
  [13, 35, 18, 26],
  [32, 35, 97, 39],
  [1000000, 1001, 857, 1],
]);

console.log(tmp);

