/* Array.map
   nums                               result
     1 => iterator function => return    1
     2 => iterator function => return    4
     3 => iterator function => return    9
     ...
*/

const nums = [1, 2, 3, 4, 5];

let result = nums.map((num) => {
  return num * num;
});

console.log(result);

// A simple Array.map example 2
const images = [
  { height: '1024px', width: '768px' },
  { height: '800px', width: '600px' },
  { height: '1320px', width: '976px' }
];

let heights = images.map((image) => {
  return image.height;
});

console.log(heights);